import React, {useContext, useEffect, useState} from 'react';
import "./index.scss";
import axios from 'axios';
import {AppContext} from "../../context/AppContext.jsx";
import {toast} from "react-toastify";


const ReadingList = () => {

    const {backendURL, userData, isLoggedIn} = useContext(AppContext)
    const [readingList, setReadingList] = useState([])
    const [status, setStatus] = useState("")

    const handleFilterChange = (event) => {
        setStatus(event.target.value)
    };

    const handleStatusChange = (value, key) => {

        axios.put(`${backendURL}/member_book`, {bookId: key, userId: userData.userid, status: value})
            .then(response => {
                console.log(response)
            })
            .catch(error => {
                alert(error)
            })
    }

    useEffect(() => {
        if (isLoggedIn) {
        axios.get(`${backendURL}/member_book?userId=${userData.userid}&status=${status}`)
            .then(response => {
                setReadingList(response.data)
            })
            .catch(error => {
                toast.error(error.message)
            })
        }

    }, [backendURL, userData, status, isLoggedIn])

    return (
        <>
            <div id={"reading-list-container"}>
                <div id="filter">
                    <h1>Filter By</h1>
                    <form>
                        <label>
                            <input
                                type={"radio"}
                                id={"All"}
                                value={""}
                                checked={status === ""}
                                onChange={handleFilterChange}
                            />
                            All
                        </label>
                        <br/>
                        <label>
                            <input
                                type={"radio"}
                                id={"not read"}
                                value={"not read"}
                                checked={status === "not read"}
                                onChange={handleFilterChange}
                            />
                            Not Read
                        </label>
                        <br/>
                        <label>
                            <input
                                type={"radio"}
                                id={"read"}
                                value={"reading"}
                                checked={status === "reading"}
                                onChange={handleFilterChange}
                            />
                            Reading
                        </label>
                        <br/>
                        <label>
                            <input
                                type={"radio"}
                                id={"read"}
                                value={"read"}
                                checked={status === "read"}
                                onChange={handleFilterChange}
                            />
                            Read
                        </label>
                    </form>
                </div>

                <div className="all-books" id={"reading-list-books"}>
                    {Object.values(readingList).map((item) => (
                        <div key={item.bookId} className="book-div">
                            <div>
                                <img className="book-img" src={item?.bookUrl.replaceAll("\\", "")}
                                     alt={`${item?.bookTitle} thumbnail`} width={168} height={269}/>
                            </div>
                            <div className={"book-info"}>
                                <p>{item?.bookTitle.length > 20 ? item?.bookTitle.substring(0, 20).concat("...") : item?.bookTitle}</p>
                                <p className={"book-author"}>By: {item?.authors?.length > 25 ? item?.authors?.substring(0, 25).concat("...") : item?.authors}</p>
                                <select defaultValue={`${item?.status.replaceAll(" ", "-")}`} className={"status-selector"} onChange={(event) => handleStatusChange(event.target.value.replaceAll("-", " "), item.bookId)}>
                                    <option value={"Not-Read"}>Not Read</option>
                                    <option value={"Reading"}>Reading</option>
                                    <option value={"Read"}>Read</option>
                                </select>
                            </div>
                        </div>
                    ))}

                </div>

            </div>

        </>
    )
}
//<p className={`${item?.status.replaceAll(" ", "-")} status`}>{item?.status}</p>

export default ReadingList;