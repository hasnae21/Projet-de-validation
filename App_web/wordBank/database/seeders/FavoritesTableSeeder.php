<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use App\Models\Favorite;

class FavoritesTableSeeder extends Seeder
{
    public function run()
    {
        $data = [
            [
            'user_id' => 1,
            'word' => 'apple',
            'phoneticT' => '/ˈæpəl/',
            'def' => 'the round fruit of a tree of the rose family, which typically has thin red or green skin and crisp flesh',
            'syn' => 'fruit',
            'ano' => 'orange',
            'exp' => 'an apple a day keeps the doctor away',
            ],
            [
            'user_id' => 1,
            'word' => 'banana',
            'phoneticT' => '/bəˈnɑːnə/',
            'def' => 'a long curved fruit which grows in clusters and has soft pulpy flesh and yellow skin when ripe',
            'syn' => 'fruit',
            'ano' => 'apple',
            'exp' => 'he slipped on a banana peel',
            ],
            [
            'user_id' => 2,
            'word' => 'banana',
            'phoneticT' => '/bəˈnɑːnə/',
            'def' => 'a long curved fruit which grows in clusters and has soft pulpy flesh and yellow skin when ripe',
            'syn' => 'fruit',
            'ano' => 'apple',
            'exp' => 'he slipped on a banana peel',
            ],
            [
            'user_id' => 2,
            'word' => 'work',
            'phoneticT' => '/bəˈnɑːnə/',
            'def' => 'a long curved fruit which grows in clusters and has soft pulpy flesh and yellow skin when ripe',
            'syn' => 'fruit',
            'ano' => 'apple',
            'exp' => 'he slipped on a banana peel',
            ],
            [
            'user_id' => 3,
            'word' => 'chocolate',
            'phoneticT' => '/ˈtʃɒk(ə)lət/',
            'def' => 'a food made from roasted ground cacao beans, typically sweetened',
            'syn' => 'candy',
            'ano' => 'vanilla',
            'exp' => 'I love dark chocolate',
            ],
            [
            'user_id' => 3,
            'word' => 'banana',
            'phoneticT' => '/bəˈnɑːnə/',
            'def' => 'a long curved fruit which grows in clusters and has soft pulpy flesh and yellow skin when ripe',
            'syn' => 'fruit',
            'ano' => 'apple',
            'exp' => 'he slipped on a banana peel',
            ],
            [
            'user_id' => 3,
            'word' => 'hello',
            'phoneticT' => '/ˈtʃɒk(ə)lət/',
            'def' => 'a food made from roasted ground cacao beans, typically sweetened',
            'syn' => 'candy',
            'ano' => 'vanilla',
            'exp' => 'I love dark chocolate',
            ],

            // Add more data as needed...
        ];

        foreach ($data as $row) {
            if (!Favorite::where('user_id', $row['user_id'])->where('word', $row['word'])->exists()) {
                    Favorite::create($row);
            }
        }
    }
}