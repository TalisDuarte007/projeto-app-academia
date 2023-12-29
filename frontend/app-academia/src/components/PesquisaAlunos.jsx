import React, { useState, useEffect } from 'react';
import Autosuggest from 'react-autosuggest';
import '../autosugest.css';

const PesquisaAlunos = ({ onSelectAluno }) => {
  const [alunos, setAlunos] = useState([]);
  const [value, setValue] = useState('');
  const [suggestions, setSuggestions] = useState([]);

  useEffect(() => {
    const fetchAlunos = async () => {
      try {
        const response = await fetch('http://localhost:8080/alunos');
        const data = await response.json();
        setAlunos(data);
      } catch (error) {
        console.error('Erro ao buscar alunos:', error);
      }
    };

    fetchAlunos();
  }, []);

  const getSuggestions = (inputValue) => {
    const regex = new RegExp(inputValue.trim(), 'i');
    return alunos.filter((aluno) => regex.test(aluno.nome));
  };

  const onSuggestionsFetchRequested = ({ value: inputValue }) => {
    setSuggestions(getSuggestions(inputValue).slice(0, 5));
  };

  const onSuggestionsClearRequested = () => {
    setSuggestions([]);
  };

  const getSuggestionValue = (suggestion) => suggestion.nome;

  const renderSuggestion = (suggestion) => 
    <div className="my-suggestion-item">
      {suggestion.nome}
    </div>;

  const onSuggestionSelected = (event, { suggestion }) => {
    onSelectAluno(suggestion.id);
  };

  const onChange = (event, { newValue }) => {
    setValue(newValue);
  };

  const inputProps = {
    placeholder: 'Digite o nome do aluno...',
    value,
    onChange,
  };

  return (
    <Autosuggest
      suggestions={suggestions}
      onSuggestionsFetchRequested={onSuggestionsFetchRequested}
      onSuggestionsClearRequested={onSuggestionsClearRequested}
      getSuggestionValue={getSuggestionValue}
      renderSuggestion={renderSuggestion}
      onSuggestionSelected={onSuggestionSelected}
      inputProps={{
        placeholder: inputProps.placeholder,
        value: inputProps.value,
        onChange: inputProps.onChange,
        className: 'my-autosuggest-input',
      }}
    />
  );
};

export default PesquisaAlunos;
