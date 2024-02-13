import React, { useState } from 'react';
import axios from 'axios';
import './DepositCalculator.css'

function DepositCalculator() {
  const [formData, setFormData] = useState({
    startDepositAmount: '',
    interestRate: '',
    investmentTerm: '',
    interestPaymentFrequency: '',
  });
  const [finalBalance, setFinalBalance] = useState(null);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  };


  const handleSubmit = async (e) => {
    e.preventDefault();
    console.log(formData);
    try {
      const response = await axios.post('/api/term-deposit/calculate-term-deposit', formData);
      setFinalBalance(response.data);
    } catch (error) {
      console.error('Error calculating term deposit:', error);
    }
   
  };

  return (
    <div>
      <h1>Deposit Calculator</h1>
      <form onSubmit={handleSubmit}>
        <label>
          Start Deposit Amount:
          <input
            type="number"
            name="startDepositAmount"
            value={formData.startDepositAmount}
            onChange={handleChange}
            required
          />
        </label>
        <br />
        <label>
          Interest Rate (%):
          <input
            type="number"
            name="interestRate"
            value={formData.interestRate}
            onChange={handleChange}
            required
          />
        </label>
        <br />
        <label>
          Investment Term (years):
          <input
            type="number"
            name="investmentTerm"
            value={formData.investmentTerm}
            onChange={handleChange}
            required
          />
        </label>
        <br />
        <label>
          Interest Payment Frequency:
          <select
            name="interestPaymentFrequency"
            value={formData.interestPaymentFrequency}
            onChange={handleChange}
            required
          >
            <option value="">Select frequency</option>
            <option value="Monthly">Monthly</option>
            <option value="Quarterly">Quarterly</option>
            <option value="Annually">Annually</option>
            <option value="At Maturity">At Maturity</option>
          </select>
        </label>
        <br />
        <button type="submit">Calculate</button>
      </form>
      {finalBalance !== null && (
        <div>
          <h2>Final Balance:</h2>
          <p>{finalBalance}</p>
        </div>
      )}
    </div>
  );
}

export default DepositCalculator;