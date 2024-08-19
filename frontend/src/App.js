import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import { CartProvider } from './context/CartContext';  // Import CartProvider
import { AuthProvider } from './context/AuthContext';  // Import AuthProvider
import AdminDashboard from './components/Admin/AdminDashboard';
import CustomerDashboard from './components/Customer/CustomerDashboard';
import ManageOrders from './components/Admin/ManageOrders';
import AddPizza from './components/Admin/AddPizza';
import ViewReports from './components/Admin/ViewReports';
import PizzaList from './components/Customer/PizzaList';
import Cart from './components/Customer/Cart';
import OrderDetails from './components/Customer/OrderDetails';
import Login from './pages/Login';
import Signup from './pages/Signup';
import Home from './pages/Home';
import Navbar from './components/Navbar';
import Footer from './components/Footer';
import './styles/App.css';

function App() {
  return (
    <AuthProvider>  {/* Wrap everything with AuthProvider for authentication */}
      <CartProvider>  {/* Wrap everything with CartProvider */}
        <Router>
          <Navbar />
          <div className="main-content">
            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/login" element={<Login />} />
              <Route path="/signup" element={<Signup />} />
              <Route path="/admin/dashboard" element={<AdminDashboard />} />
              <Route path="/admin/manage-orders" element={<ManageOrders />} />
              <Route path="/admin/add-pizza" element={<AddPizza />} />
              <Route path="/admin/view-reports" element={<ViewReports />} />
              <Route path="/customer/dashboard" element={<CustomerDashboard />} />
              <Route path="/customer/pizza-list" element={<PizzaList />} />
              <Route path="/customer/cart" element={<Cart />} />
              <Route path="/customer/orders" element={<OrderDetails />} />
            </Routes>
          </div>
          <Footer />
        </Router>
      </CartProvider>
    </AuthProvider>
  );
}

export default App;
