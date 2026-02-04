import axios from "axios";
import {AppConstraints} from "../util/constraints.js";
import {useEffect, useState} from "react";
import {AppContext} from "./AppContext.jsx";
import {toast} from "react-toastify";

export const AppContextProvider = (props) => {

    useEffect(() => {
        axios.defaults.withCredentials = true;
    }, [])

    const backendURL = AppConstraints.BACKEND_URL;
    const [isLoggedIn, setIsLoggedIn] = useState(false);
    const [userData, setUserData] = useState(() => {
        const stored = localStorage.getItem("userData");
        return stored ? JSON.parse(stored) : null;
    });


    const getUserData = async () => {
        try {
            const response = await axios.get(`${backendURL}/profile/me`);
            if (response.status === 200) {
                setUserData(response.data);
                console.log(response.data)
                localStorage.setItem("userData", JSON.stringify(response.data));

            } else {
                toast.error("Unable to retrieve profile");
            }
        }catch(error) {
            toast.error(error.message);
        }
    }

    useEffect(() => {
        const checkAuth = async () => {
            try {
                const response = await axios.get(backendURL + "/auth/is-authenticated");

                if (response.status === 200 && response.data === true) {
                    setIsLoggedIn(true);
                } else {
                    setIsLoggedIn(false);
                    setUserData(null);
                }
            } catch (error) {
                toast.error(error.message)
            }
        };

        checkAuth();
    }, [backendURL, userData]);


    const contextValue = {
        backendURL,
        isLoggedIn, setIsLoggedIn,
        userData, setUserData,
        getUserData,
    }

    return (
        <AppContext.Provider value={contextValue}>
            {props.children}
        </AppContext.Provider>
    )

}