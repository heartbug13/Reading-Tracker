import React, { useState } from 'react';
import "./index.scss";
import {useNavigate} from 'react-router-dom'

const Search = () => {
    const navigate = useNavigate();
    const [searchQuery, setSearchQuery] = useState('');
    const [selectedValue, setSelectedValue] = useState('');

    const handleSearchChange = event => {
        setSearchQuery(event.target.value)
    }

    const handleGoButtonClick = () => {
       navigate(`/data?search=${encodeURIComponent(searchQuery)}&advancedSearch=${selectedValue}`);
    }

    const handleSelectChange = event => {
        setSelectedValue(event.target.value)
    }

    return (
        <>
            <div id="search-div">
                <input
                    id="search-input"
                    type="text"
                    className={"search-bar"}
                    placeholder={selectedValue.length === 0 ? `Search` : `Search By ${selectedValue}`}
                    onChange={handleSearchChange}
                />

                {/*
                <button id="advanced-search-btn">
                    Advanced Search
                </button>*/}

                <button
                    onClick={handleGoButtonClick}
                    id="submit"
                >
                    Go
                </button>
            </div>

            <div id="advanced-search">
                <h1 id="title">Advanced Search</h1>
                <label> Search By:
                    <select name="search-option" id="search-option" value={selectedValue} onChange={handleSelectChange}>
                        <option value="">Search Options</option>
                        <option value="Title">Title</option>
                        <option value="Author">Author</option>
                        <option value="Subject">Subject</option>
                    </select>
                </label>
            </div>
        </>
    )
}

export default Search;