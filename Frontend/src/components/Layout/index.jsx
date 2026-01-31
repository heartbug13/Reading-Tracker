import React from 'react';
import "./index.scss";
import {Outlet} from "react-router-dom";
import Menu from '../Menu/index.jsx'

const Layout = () => {
    return (
        <div>
            <Menu/>
            <div className={"child-body"}>
                <Outlet/>
            </div>
        </div>
    )
}

export default Layout