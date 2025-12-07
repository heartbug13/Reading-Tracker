import React/*, { useEffect, useState } */from 'react'
//import reactLogo from './assets/react.svg'
//import viteLogo from '/vite.svg'
import './App.css'
//import axios from 'axios';
import Search from './components/Search.jsx'

function App() {
    /*
    const [data, setData] = useState([])
    const [loading, setLoading] = useState(true)
    const [error, setError] = useState(null)

    useEffect(() => {
        axios.get("https://jsonplaceholder.typicode.com//posts")
            .then((response) => {
                setData(response.data)
                setLoading(false)
            })
            .catch((err) => {
                setError(err.message)
                setLoading(false)
            })
    }, [])

    if (loading) return <div>Loading...</div>
    if (error) return <div>Error: {error}</div>
*/
    return (
        <>
        <div>
            <Search />
        </div>
        </>
    )

}

export default App
