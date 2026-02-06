import React, {useEffect, useContext, useState} from 'react';
import "./index.scss";
import axios from 'axios';
import {AppContext} from "../../context/AppContext.jsx";

const BookData = () => {

    const [data, setData] = useState([])
    const [loading, setLoading] = useState(true);
    const [addingBookLoading, setAddingBookLoading] = useState(false);
    const [error, setError] = useState(null);
    const {backendURL, isLoggedIn, userData} = useContext(AppContext);

    const params = new URLSearchParams(window.location.search);
    const searchValue = params.get('search');
    const searchType = params.get('advancedSearch');

    const [index, setIndex] = useState(0);
    const [totalResult, setTotalResult] = useState(0);
    const [isBackDisabled, setIsBackDisabled] = useState(true);
    const [isNextDisabled, setIsNextDisabled] = useState(false);
    const [isViewingBook, setIsViewingBook] = useState(false);
    const [currentBook, setCurrentBook] = useState();

    useEffect(() => {
        const checkIndex = () => {
            if ((index + 10) > totalResult) {
                setIsNextDisabled(true)
            } else {
                setIsNextDisabled(false)
            }

            if ((index - 10) < 0) {
                setIsBackDisabled(true)
            } else {
                setIsBackDisabled(false)
            }
        }

        checkIndex()
    })

    const handleNextButtonClick = () => {
        setIndex(index + 10)

    }

    const handleBackButtonClick = () => {
        setIndex(index - 10)
    }

    const handleBookClick = (key) => {

        const books = data.items;
        const book = books.find(b => b.id === key)
        if (!book) {
            alert("error retrieving book")
        } else {
            setIsViewingBook(true);
            setCurrentBook(book)
        }

    }

    const handleAddToReadingListClick = async() => {

        if (isLoggedIn) {
            setAddingBookLoading(true)
            axios.post(`${backendURL}/member_book`, {
                userId: userData.userid,
                book: {
                    bookId: currentBook?.id,
                    bookTitle: currentBook?.volumeInfo?.title,
                    coverUrl: currentBook?.volumeInfo?.imageLinks?.thumbnail,
                    author: currentBook?.volumeInfo?.authors[0]
                }})
                .then(() => {
                    setAddingBookLoading(false)
                    alert(`${currentBook?.volumeInfo?.title} added to your reading list :)`)
                })
                .catch(error => {
                    alert(error)
                })
        } else {
            alert("Please log in before adding books to your reading list")
        }
    }

    useEffect(() => {
        console.log(currentBook)
    })

    useEffect(() => {
       axios.get(`${backendURL}/book/search?search=${searchValue}&searchOption=${searchType}&index=${index}`)
           .then((response) => {
               setData(response.data)
               setLoading(false)
               setTotalResult(response.data.totalItems)
           })
           .catch((error) => {
               setError(error.message)
               setLoading(false)
           })
    }, [backendURL, searchType, index, searchValue])

   if (loading) return <div>Loading...</div>
   if (error) return <div>Error: {error}</div>

    return (
        <>
            {
                isViewingBook ? (
                    <div>
                        <button id={"book-back-btn"} onClick={() => setIsViewingBook(false)}>
                            Back To Search
                        </button>
                        <div className={"book-container"}>
                            <div className={"book-img-container"}>
                                <img className="book-img"
                                     src={currentBook?.volumeInfo?.imageLinks?.thumbnail}
                                     alt={`${currentBook.volumeInfo.title} thumbnail`}
                                     width={"100%"}
                                     height={"auto"}
                                />
                            </div>
                            <div className={"book-info-container"}>
                                <h1>{currentBook?.volumeInfo?.title}</h1>
                                <h2>
                                    By: {
                                        currentBook?.volumeInfo.authors.map((author, index) =>
                                            (
                                                index === 0 ? (author) : (", " + author)
                                            )
                                        )
                                    }
                                </h2>
                                <p>
                                    {currentBook?.volumeInfo.description}
                                </p>

                                <div className={"category-container"}>
                                    {currentBook?.volumeInfo?.categories.map((category) => (
                                        <div key={category} className={"category-box"}>
                                            {category}
                                        </div>
                                    ))}
                                </div>

                            </div>
                            <div className={"book-btn-container"}>
                                <button disabled={addingBookLoading} onClick={handleAddToReadingListClick}>
                                    {addingBookLoading ? "Loading" : "Add to Reading List"}
                                </button>
                                <a target="_blank" href={currentBook?.volumeInfo?.previewLink}>
                                    <button>Preview Book</button>
                                </a>

                            </div>
                        </div>
                    </div>
                ) : (
                    <div className={"search-container"}>
                        <div className="all-books" id={"search-books"}>
                            {Object.values(data).map((items) => (
                                Object.values(items).map((test => (
                                    <div key={test.id}
                                         className="book-div"
                                         onClick={() => handleBookClick(test.id)}
                                    >
                                        <div>
                                            <img className="book-img"
                                                 src={test?.volumeInfo?.imageLinks?.thumbnail}
                                                 alt={`${test.volumeInfo.title} thumbnail`}
                                                 width={168}
                                                 height={269}
                                            />
                                        </div>
                                        <div className={"book-info"}>
                                            <p>
                                                {(test?.volumeInfo?.title.length > 20) ? (
                                                    test?.volumeInfo?.title.substring(0, 20).concat("...")
                                                ) : (
                                                    test?.volumeInfo?.title
                                                )}
                                            </p>
                                            <p
                                                className={"book-author"}
                                            >
                                                By: {(test?.volumeInfo?.authors?.[0].length > 25) ? (
                                                        test?.volumeInfo?.authors?.[0].substring(0, 25).concat("...")
                                                    ) : (
                                                        test?.volumeInfo?.authors?.[0]
                                                    )}
                                            </p>
                                        </div>
                                    </div>
                                )))
                            ))}
                        </div>
                        <div className={"pagination-container"}>
                            <button disabled={isBackDisabled}
                                    className={`${isBackDisabled ? 'disabled' : 'enabled'} pagination-btn`}
                                    onClick={handleBackButtonClick}>
                                {'<'} Back
                            </button>
                            <button disabled={isNextDisabled}
                                    className={`${isNextDisabled ? 'disabled' : 'enabled'} pagination-btn`}
                                    onClick={handleNextButtonClick}>
                                Next {'>'}
                            </button>
                        </div>
                    </div>
                )
            }


        </>
    )
}

export default BookData