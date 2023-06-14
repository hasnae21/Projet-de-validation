const Phonetics = ({ mean }) => {
    return (
        <div>
            {mean.map(val => {
                <div>
                    <h4>&nbsp; En us:{val.phonetics[0].text} &nbsp;  / &nbsp; Audio en us: {val.phonetics[0].audio} &nbsp;</h4>
                    <br />
                    <h4>&nbsp; En uk:{val.phonetics[1].text} &nbsp;  / &nbsp; Audio en uk: {val.phonetics[1].audio} &nbsp;</h4>
                    <hr />
                </div>
            })}
        </div>
    );
};

export default Phonetics;
