import { AppstoreOutlined, MailOutlined, SettingOutlined } from '@ant-design/icons';
import { Layout, Menu } from 'antd';
import React, { useEffect, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { useSelector } from 'react-redux'
import './index.css'
import axios from 'axios';
const { Sider } = Layout;

//需要控制展开的菜单key值
const rootSubmenuKeys = ['/user', '/right', '/inStock', '/todo', '/archives'];

//导航栏图标映射
const iconList = {
  '/user': <AppstoreOutlined />,
  '/right': <MailOutlined />,
  '/inStock': <SettingOutlined />,
  '/todo': <MailOutlined />,
  '/archives': <AppstoreOutlined />,
}

export default function SiderMenu() {
  const collapseReducer = useSelector(state => state.collapseReducer)
  //控制菜单是否折叠，等待后期用redux
  //antd复制控制展开的菜单项
  const [openKeys, setOpenKeys] = useState(['sub1']);
  const [items, setItems] = useState([])
  //从token中解构rightsId和id
  const token = JSON.parse(localStorage.getItem('token'))

  useEffect(() => {
    //读取当前用户的信息
    axios.get(`http://localhost:7899/staff/${token.id}`).then(resStaff => {
      // console.log(token);
      // console.log(resStaff);
      setItems(token.rights.map(item => {
        //拥有权限而且
        if (item.right === 1 && resStaff.data.showed.includes(item.key)) {
          return {
            key: item.key,
            label: item.title,
            //icon通过映射表获取
            icon: iconList[item.key],
            children: item.children.map(item => {
              if (item.right === 1 && resStaff.data.showed.includes(item.key)){
                return {
                  key: item.key,
                  label: item.title,
                }
              }
              return null
            })
          }
        }
        return null
      }))
    })
  // eslint-disable-next-line
  }, [])
  const navigate = useNavigate()
  //antd复制
  const onOpenChange = (keys) => {
    const latestOpenKey = keys.find((key) => openKeys.indexOf(key) === -1);
    if (rootSubmenuKeys.indexOf(latestOpenKey) === -1) {
      setOpenKeys(keys);
    } else {
      setOpenKeys(latestOpenKey ? [latestOpenKey] : []);
    }
  };
  //点击菜单栏执行的回调
  const handleClick = (item) => {
    navigate(item.key)
  }


  return (
    <div className='SiderMenu'>
      <Sider trigger={null} collapsible collapsed={collapseReducer.collapse}>
        <div className="logo" style={{ height: '64px' }} >{collapseReducer.collapse ? <img src="/19-cat.png" alt='logo' width="45px" /> : <div><img src="/19-cat.png" alt='logo' width="36px" /><div>まるまるペット病院</div></div>}</div>
        <Menu
          mode="inline"
          openKeys={openKeys}
          onOpenChange={onOpenChange}
          // style={{
          //   width: 200,
          // }}
          items={items}
          onClick={(item) => { handleClick(item) }}
        />
      </Sider>
    </div>
  )
}
