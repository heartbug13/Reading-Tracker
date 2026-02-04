import React, {useContext, useEffect} from 'react';
import "./index.scss";
import {AppContext} from "../../context/AppContext.jsx";
import {assets} from "../../assets/assets.js";
import {useNavigate} from 'react-router-dom'
import axios from "axios";
const Menu = () => {

    const {isLoggedIn, backendURL, setIsLoggedIn, setUserData} = useContext(AppContext);
    const navigate = useNavigate();

    const handleLogout = () => {
        axios.post(`${backendURL}/auth/logout`)
            .then(() => {
                setIsLoggedIn(false)
                localStorage.removeItem("userData");
                setUserData([])
                navigate("/")

            })
            .catch(error => {
                alert(error)
            })

    }

    return (
        <ul>
            <li onClick={() => navigate("/")}>Home</li>
            {isLoggedIn && <li onClick={() => navigate("/reading-list")}>Reading List</li>}
            <li className={"push"}>
                {isLoggedIn ? (
                    <div className={"dropdown"}>
                        <img src={assets.person_icon} alt={"profile icon"}/>
                        <div className={"dropdown-content"}>
                            <a onClick={() => handleLogout()}>Log Out</a>
                        </div>
                    </div>
                ) : (
                    <button id="login-btn" onClick={() => navigate("/login")}>
                        Login
                    </button>
                )}
            </li>
        </ul>
    )
}

export default Menu;