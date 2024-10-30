import React, { useState } from "react";
import './ViewerLogin.css';
import { FaEnvelope, FaLock, FaUser } from "react-icons/fa";
import { useNavigate } from 'react-router-dom';

const ViewerLogin = () => {
    const [action, setAction] = useState('');
    const navigate = useNavigate(); // Hook to handle navigation

    const registerLink = () => {
        setAction('active');
    };

    const loginLink = () => {
        setAction('');
    };

    const handleLogin = (e) => {
        e.preventDefault();
        // Perform your authentication here (dummy login for example purposes)
        // If successful, navigate to the home page
        navigate('/');
    };

    return (
        <div className="login-container">
          
            <header className="Lheader">
                <h1>Welcome to Experience the Shopping Aura</h1>
            </header>


            <div className={`wrapper ${action}`}>
                <div className="form-box login">
                    <form onSubmit={handleLogin}>
                        <h1>Login</h1>
                        <div className="input-box">
                            <input type="text" placeholder="Username" required />
                            <FaUser className="icon" />
                        </div>
                        <div className="input-box">
                            <input type="password" placeholder="Password" required />
                            <FaLock className="icon" />
                        </div>
                        <div className="remember-forgot">
                            <label><input type="checkbox" />Remember</label>

                            <a href="/forgot-password">Forgot Password?</a>


                        </div>
                        <button type="submit">Login</button>
                        <div className="register-link">
                            <p> Don't have an account?
                                <button onClick={registerLink} className="link-style">Register</button>

                            </p>
                        </div>
                    </form>
                </div>

                <div className="form-box register">
                    <form>
                        <h1>Registration</h1>
                        <div className="input-box">
                            <input type="text" placeholder="Username" required />
                            <FaUser className="icon" />
                        </div>
                        <div className="input-box">
                            <input type="email" placeholder="Email" required />
                            <FaEnvelope className="icon" />
                        </div>
                        <div className="input-box">
                            <input type="password" placeholder="Password" required />
                            <FaLock className="icon" />
                        </div>
                        <div className="remember-forgot">
                            <label><input type="checkbox" />I agree to terms & conditions</label>
                        </div>
                        <button type="submit">Register</button>
                        <div className="register-link">
                            <p> Already have an account?
                                <button onClick={loginLink} className="link-style">Login</button>

                            </p>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    );
};

export default ViewerLogin;
