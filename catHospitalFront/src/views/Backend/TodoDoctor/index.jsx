import axios from 'axios'
import React from 'react'
import { useState } from 'react'
import { useEffect } from 'react'
import TodoList from '../../../ component/TodoList'
export default function TodoDoctor() {
  const [data,setData] = useState([])
  useEffect(()=>{
    const staffId = JSON.parse(localStorage.getItem('token')).id
    axios.get(`http://localhost:7899/records/doctor/${staffId}`).then(res=>{
      setData(res.data);
      // console.log(res.data);
    })
  },[])

  return (
    <div>
      <TodoList data={data} />
    </div>
  )
}
