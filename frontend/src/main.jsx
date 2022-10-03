import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import './index.css'
import reducer, { inicialState } from './reducer'
import { StateProvider } from './StateProvider'

ReactDOM.createRoot(document.getElementById('root')).render(
  <React.StrictMode>
    <StateProvider inicialState={inicialState} reducer={reducer}>
      <App />
    </StateProvider>
  </React.StrictMode>
)
