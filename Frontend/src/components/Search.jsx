import React, { useState } from 'react'

const Search = () => {
    const [searchQuery, setSearchQuery] = useState('');

    const handleSearchChange = event => {
        setSearchQuery(event.target.value)
        console.log(event)
    }

    const handleGoButtonClick = () => {
        window.location.href = `/data?title=${encodeURIComponent(searchQuery)}`;
    }

    return (
        <>
            <div>
                <input
                    type="text"
                    value={searchQuery}
                    onChange={handleSearchChange}
                />
            </div>
            <button onClick={handleGoButtonClick}>Go</button>
        </>
    )
}

export default Search;