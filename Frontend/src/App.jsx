import React from 'react'
import { BrowserRouter, Routes, Route, Link } from 'react-router-dom';
import './App.css'
import Search from './components/Search/index.jsx'
import BookData from './components/BookData/index.jsx'
import Layout from './components/Layout/index.jsx'
import Login from "./components/Login/index.jsx";
import ReadingList from "./components/ReadingList/index.jsx";

function App() {
    return (
        <>
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Layout />}>
                        <Route index element={<Search />} />
                        <Route path="/data" element={<BookData />} />
                        <Route path="/login" element={<Login />} />
                        <Route path="/reading-list" element={<ReadingList />}/>
                    </Route>
                </Routes>
            </BrowserRouter>
        </>
    )

}

export default App
