import React, { useState } from 'react';
import '../../styles/AddPizza.css';  

function AddPizza() {
  const [pizzas, setPizzas] = useState([
    { id: 1, name: 'Pepperoni', price: 99.99 },  
    { id: 2, name: 'Margherita', price: 89.99 },
  ]);
  const [newPizza, setNewPizza] = useState({ name: '', price: '' });

  const addPizza = () => {
    const id = pizzas.length + 1;
    setPizzas([...pizzas, { id, ...newPizza, price: parseFloat(newPizza.price) }]);
    setNewPizza({ name: '', price: '' });
  };

  const removePizza = (id) => {
    setPizzas(pizzas.filter(pizza => pizza.id !== id));
  };

  return (
    <div className="add-pizza-container">
      <h2>Add/Remove Pizzas</h2>
      <div className="pizza-form">
        <input
          type="text"
          placeholder="Pizza Name"
          value={newPizza.name}
          onChange={(e) => setNewPizza({ ...newPizza, name: e.target.value })}
        />
        <input
          type="number"
          placeholder="Pizza Price (in ₹)"
          value={newPizza.price}
          onChange={(e) => setNewPizza({ ...newPizza, price: e.target.value })}
        />
        <button className="add-pizza-button" onClick={addPizza}>Add Pizza</button>
      </div>
      <div className="pizza-list">
        {pizzas.map(pizza => (
          <div key={pizza.id} className="pizza-card">
            <h3>{pizza.name}</h3>
            <p>Price: ₹{pizza.price}</p>
            <button className="remove-pizza-button" onClick={() => removePizza(pizza.id)}>Remove Pizza</button>
          </div>
        ))}
      </div>
    </div>
  );
}

export default AddPizza;
