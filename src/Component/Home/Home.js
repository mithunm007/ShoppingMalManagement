import React from 'react';
import { useNavigate } from 'react-router-dom';
import { FaShoppingCart, FaUser, FaStore, FaShoppingBag, FaComments, FaTshirt, FaSignInAlt } from 'react-icons/fa'; // Import the necessary icons
import './Home.css';
import { FaPerson } from 'react-icons/fa6';


const Home = () => {
  const navigate = useNavigate();

  const handleNavigate = (path) => {
    navigate(path);
  };

  return (
    <div className="home-container">
      <header className="header">
        <h1>STYLE</h1>
      </header>

      <nav className="nav-bar">

     

      
        <button onClick={() => handleNavigate('/shop')}>
          <FaShoppingBag /> Shop
        </button>
        <button onClick={() => handleNavigate('/cart')}>
          <FaShoppingCart /> Cart
        </button>
        <button onClick={() => handleNavigate('/employee')}>
          <FaUser /> Employee
        </button>
        <button onClick={() => handleNavigate('/guest')}>
          <FaPerson /> Guest
        </button>
        <button onClick={() => handleNavigate('/mall')}>
          <FaStore /> Mall
        </button>
        <button onClick={() => handleNavigate('/review')}>
          <FaComments /> Review
        </button>
        <button onClick={() => handleNavigate('/product')}>
          <FaTshirt /> Product
        </button>
        <button onClick={() => handleNavigate('/Viewerlogin')}>
          <FaSignInAlt /> ViewerLogin
        </button>
      </nav>

      {/* Rest of your content */}
      <div className="style-scroll">
        <div className="scroll-text">
          <h1>Shop your STYLE</h1>
          <h1>Wear your STYLE</h1>
          <h1>Vibe your STYLE</h1>
        </div>
      </div>


      <div className="top-brands-container">

        <header className="eader">
          <h1>Skin Care Products</h1>
        </header>

        <div className="brand-card brand1">

        </div>
        <div className="brand-card brand2">

        </div>
        <div className="brand-card brand3">

        </div>
        <div className="brand-card brand4">

        </div>
        <div className="brand-card brand5">

        </div>
        {/* Add more brand cards as needed */}
      </div>


      <div className="op-brands-container">

        <header className="ader">
          <h1>Shoe Brands</h1>
        </header>

        <div className="brand-card brand6">

        </div>
        <div className="brand-card brand7">

        </div>
        <div className="brand-card brand8">

        </div>
        <div className="brand-card brand9">

        </div>
        <div className="brand-card brand10">

        </div>
        {/* Add more brand cards as needed */}
      </div>


      <div className="p-brands-container">

        <header className="der">
          <h1>Kids</h1>
        </header>

        <div className="rand-card brand11"></div>

      </div>

      <div className="h-brands-container">

        <header className="er">
          <h1>Men</h1>
        </header>

        <div className="and-card brand12"></div>

      </div>


      <div className="about-container">
        <div className="about-card">
          <h2>!!! Know Us Well !!!</h2>
          <p>Discover the latest trends, find your favorite stores, and stay informed about events in our mall. Our user-friendly app offers personalized recommendations, easy navigation, and exclusive offers.</p>
          <p>Never miss a sale or event again with our shopping mall app. Quickly locate stores, browse menus, and enjoy a seamless shopping experience.</p>
          <p>Experience the convenience of shopping at the mall from the comfort of your home. Our app features interactive maps, real-time parking updates, and exclusive deals.</p>
        </div>
      </div>

      <div className="contact-us">
        <h2>Contact Us</h2>
        <div className="contact-card">
          <div className="contact-item">
            <i className="fas fa-phone-alt"></i>
            <div className="contact-text">
              <h3>Call Us</h3>
              <p>+91 9980659417</p>
            </div>
          </div>

          <div className="contact-item">
            <i className="fas fa-envelope"></i>
            <div className="contact-text">
              <h3>Email Us</h3>
              <p>youknowwhozubu0105@gmail.com</p>
            </div>
          </div>

          <div className="contact-item">
            <i className="fas fa-map-marker-alt"></i>
            <div className="contact-text">
              <h3>Visit Us</h3>
              <p>#81, Shopping Street, Mall City, London</p>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Home;
