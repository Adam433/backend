import React from 'react';
import { useRoutes } from 'react-router-dom';
import RouterList from './router/RouterList'
import './App.less';
import { Provider } from 'react-redux';
import  store  from './redux/store'

export default function App() {
  //useRoutes里面传进来的是一个RouterList数组
  let element = useRoutes(RouterList())
  return (
    <Provider store={store} >
      <div className="App">
        {element}
      </div>
    </Provider>
  )
};
