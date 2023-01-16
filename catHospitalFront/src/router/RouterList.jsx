import { Navigate } from 'react-router-dom';
import { useEffect, useState } from 'react';

import Guest from '../views/Guest'
import Login from '../views/Login'
import Backend from '../views/Backend'
import NotFound from '../views/NotFound'
import UserList from '../views/Backend/UserList'
import UserAdd from '../views/Backend/UserAdd'
import UserEdit from '../views/Backend/UserEdit'
import RightRole from '../views/Backend/RightRole'
import RightPage from '../views/Backend/RightPage'
import InstockList from '../views/Backend/InStockList'
import InstockPricing from '../views/Backend/InstockPricing'
import TodoDoctor from '../views/Backend/TodoDoctor'
import TodoAssistant from '../views/Backend/TodoAssistant'
import TodoReserve from '../views/Backend/TodoReserve'
import ArchivesCats from '../views/Backend/ArchivesCats'
import ArchivesRecords from '../views/Backend/ArchivesRecords'
import ArchivesAddrecord from '../views/Backend/ArchivesAddrecord'
import Appointment from '../views/Guest/Appointment';
import View from '../views/Guest/View';
import Doctor from '../views/Guest/Doctor';
import Register from '../views/Guest/Register';

//路由映射表
const routeList = {
    "/user/list": <UserList />,
    "/user/add": <UserAdd />,
    "/user/edit": <UserEdit />,
    "/right/role": <RightRole />,
    "/right/page": <RightPage />,
    "/inStock/list": <InstockList />,
    "/inStock/pricing": <InstockPricing />,
    "/todo/doctor": <TodoDoctor />,
    "/todo/assistant": <TodoAssistant />,
    "/todo/reserve": <TodoReserve />,
    "/archives/cats": <ArchivesCats />,
    "/archives/records": <ArchivesRecords />,
    "/archives/addrecord": <ArchivesAddrecord />,
}
export default function RouterList() {
    const [routerList, setRouterList] = useState([])
    let token = localStorage.getItem('token')
    //获取权限数组
    useEffect(() => {
        if (token !== null) {
            const tokenJSON = JSON.parse(token)
            // console.log(tokenJSON);
            let arr = []
            tokenJSON.rights.forEach(element => {
                element.children.forEach(item=>{
                    if(item.right===1){
                        arr.push(item.key)
                    }
                })
            });
            setRouterList(arr)
        }
    }, [token])

    return (
        [
            {
                path: '/', element: token !== null ? <Backend /> : <Navigate to='/login' />,
                children: [
                    ...routerList.map(item => {
                        return ({
                            path: item,
                            element: routeList[item]
                        })
                    }),
                    { path: '/', element: <Navigate to='/user/edit' /> },
                ]
            },
            { path: '/login', element: <Login /> },
            {
                path: '/guest', element: <Guest />,
                children: [{
                    path: '/guest/appointment',
                    element: <Appointment />
                },
                {
                    path: '/guest/view/',
                    element: <View />
                },
                {
                    path: '/guest/register',
                    element: <Register />
                },
                {
                    path: '/guest/doctor/:id',
                    element: <Doctor />
                }
                ]
            },
            { path: '*', element: <NotFound /> },
        ]
    )
}
