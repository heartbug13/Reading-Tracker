/*
import {Link, useNavigate} from "react-router-dom";
import {assets} from "../assets/assets.js";
 */
import {React, useContext, useState} from "react";
import axios from "axios";
//import {AppContext} from "../context/AppContext.jsx";
//import {toast} from "react-toastify";
import "./index.scss";
import {AppContext} from "../../context/AppContext.jsx";
import {useNavigate} from "react-router-dom";


const Login = () => {

    const [isCreateAccount, setIsCreateAccount] = useState(false);

    const [username, setUsername] = useState("");
    const [email, setEmail] = useState("");
    const [password, setPassword] = useState("");
    const {backendURL, setIsLoggedIn, getUserData} = useContext(AppContext);
    const [error, setError] = useState("");
    const [isActive, setIsActive] = useState(false)
    const navigate = useNavigate()


    const onSubmitHandler = async(event) => {
        event.preventDefault()
        axios.defaults.withCredentials = true;

        if (isCreateAccount) {

            axios.post(`${backendURL}/profile/register`, {username, email, password})
                .then(() => {
                    setIsActive(false)
                    navigate("/")
                })
                .catch((error) => {
                    setError(error.response.data.message)
                    setIsActive(true)
                })


        } else {

            axios.post(`${backendURL}/auth/login`, {email, password})
                .then(() => {
                    setIsActive(false)
                    setIsLoggedIn(true)
                    getUserData()
                    navigate("/")
                })
                .catch((error) => {
                    setError(error.response.data.message)
                    setIsActive(true)
                })

        }

    }
    const handleEmailChange = event => {
        setEmail(event.target.value)
    }

    const handleUsernameChange = event => {
        setUsername(event.target.value)
    }

    const handlePasswordChange = event => {
        setPassword(event.target.value)
    }

    return (
        <form className={"form-container"} onSubmit={onSubmitHandler}>

            {isCreateAccount ? (
                <div>
                    <h1>Sign up</h1>
                    <p>Enter your credentials to create your account</p>
                </div>
            ) : (
                <div>
                    <h1>Log In</h1>
                    <p>Enter your credentials to access your account</p>
                </div>
            )}

            <div className={"input-container"}>
                <input
                    className={"input-box"}
                    type={"text"}
                    placeholder={"Email Address"}
                    onChange={handleEmailChange}
                />
                { isCreateAccount && (
                    <input
                        className={"input-box"}
                        type={"text"}
                        placeholder={"Username"}
                        onChange={handleUsernameChange}
                    />
                )}
                <input
                    className={"input-box"}
                    type={"password"}
                    placeholder={"Password"}
                    onChange={handlePasswordChange}
                />
            </div>

            <div className={`error-message ${isActive ? 'active' : ''}`}>
                {error}
            </div>

            <div>
                <button
                    type={"submit"}
                    id={"submit-btn"}
                    onClick={(event) => onSubmitHandler(event)}
                >
                    Submit
                </button>
            </div>

            {isCreateAccount ? (
                <p>Already have an account? <a onClick={() => setIsCreateAccount(false)}>Log In</a></p>
            ) : (
                <p>Don’t have an account? <a onClick={() => setIsCreateAccount(true)} >Create one</a></p>
            )}

        </form>
    )
}

export default Login;