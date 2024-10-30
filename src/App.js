import React from 'react';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import Home from './Component/Home/Home';
import Shop from './Component/Shop/Shop';
import Cart from './Component/Cart/Cart';
import Employee from './Component/Employee/Employee';
import ViewerLogin from './Component/ViewerLogin/ViewerLogin';
import Guest from './Component/Guest/Guest';
import Mall from './Component/Mall/Mall';
import Review from './Component/Review/Review';
import Product from './Component/Product/Product';

import './index.css';

// You can add more components here

const App = () => {
  return (

    
    <Router>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/Shop" element={<Shop />} />
        <Route path="/Cart" element={<Cart />} />
        <Route path="/Employee" element={<Employee />} />
        <Route path="/Guest" element={<Guest />} />
        <Route path="/Mall" element={<Mall />} />
        <Route path="/Review" element={<Review />} />
        <Route path="/Product" element={<Product />} />
        <Route path="/ViewerLogin" element={<ViewerLogin />} />
        {/* Add routes for other components here */}
      </Routes>
    </Router>
  );
};

export default App;
