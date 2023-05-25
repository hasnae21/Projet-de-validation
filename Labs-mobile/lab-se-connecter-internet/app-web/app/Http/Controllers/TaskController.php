<?php

namespace App\Http\Controllers;

use Illuminate\Http\Request;

class TaskController extends Controller
{
    use SetsJsonResponse;

    /**
     * Store a new task or subtask.
     *
     * @param  Request  $request
     * @return Response
     */
    public function store(Request $request)
    {
        $task = Task::create([
            'parent_id' => $request->parent_id,
            'title' => $request->title,
            'due_date' => $request->due_date,
        ]);

        return $this->setSuccessResponse($task->toArray(), 201);
    }

    /**
     * Lists all the tasks along with subtasks.
     *
     * @return Response
     */
    public function index()
    {
        $tasks = Task::all();
        return $this->setSuccessResponse($tasks->toArray());
    }

    /**
     * Marks a task or a subtask complete.
     *
     * @param  Request  $request
     * @return Response
     */
    public function complete(Request $request)
    {
        $task = Task::findOrFail($request->task_id);

        $task->status = true;

        $task->save();

        return $this->setSuccessResponse(['message' => 'Task has been completed.']);
    }

    /**
     * Deletes a task or subtask.
     *
     * @param  Request  $request
     * @param  int  $id
     * @return Response
     */
    public function delete(Request $request, $id)
    {
        $task = Task::findOrFail($id);

        $task->delete();

        return $this->setSuccessResponse([], 204);
    }

    /**
     * Filter tasks by title.
     *
     * @param  Request  $request
     * @return Response
     */
    public function filter(Request $request)
    {
        $tasks = Task::with('subtasks')
            ->where([
                'parent_id' => null,
            ])
            ->when($request->query('title'), function ($query, $title) {
                return $query->where('title', 'like', "%{$title}%");
            })
            ->when($request->query('due_date'), function ($query, $due) {
                if ($due === 'today') {
                    return $query->where('due_date', Carbon::today());
                } elseif ($due === 'this_week') {
                    return $query->whereBetween('due_date', [now()->startOfWeek(), now()->endOfWeek()]);
                } elseif ($due === 'next_week') {
                    return $query->whereBetween('due_date', [now()->addDays(7)->startOfWeek(), now()->addDays(7)->endOfWeek()]);
                } elseif ($due === 'overdue') {
                    return $query->where('due_date', '<', now());
                }

                return $query;
            })
            ->orderBy('due_date')
            ->paginate(15);

        return $this->setSuccessResponse($tasks->toArray());
    }
}