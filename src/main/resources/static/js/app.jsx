const React = require('react');
const ReactDOM = require('react-dom');
import {MainPage} from './mainpage.jsx';

let exampleprop= 2;

ReactDOM.render(<MainPage prop1={exampleprop}  />, document.getElementById('app_root'));