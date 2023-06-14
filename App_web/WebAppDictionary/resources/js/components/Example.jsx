const Example = ({ mean }) => {
    return (
        <div>
            {mean.map(val =>
                val.meanings.map(means =>
                    means.definitions?.map((def) => (
                        <div>
                            {def.example ? <div key={def.example} > -  {def.example}</div> : ''}
                        </div>
                    ))))}
        </div>
    );
};

export default Example;
