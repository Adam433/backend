import axios from 'axios'
import React from 'react'
import { useState } from 'react'
import { useEffect } from 'react'
import TodoList from '../../../ component/TodoList'
export default function TodoAssistant() {
  const [data,setData] = useState([])
  useEffect(()=>{
    axios.get(`http://localhost:7899/records/assistant`).then(res=>{
      setData(res.data);
      // console.log(res.data);
    })
  },[])

  return (
    <div>
      <TodoList data={data}/>
    </div>
  )
}
