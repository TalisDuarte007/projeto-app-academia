
-- Perna
INSERT INTO Exercicios (nome, descricao, musculo_trabalhado, categoria) VALUES
  ('Agachamento Livre', 'Levante e desça com a barra nas costas', 'Quadríceps', 'PERNA'),
  ('Leg Press', 'Pressione a plataforma com as pernas', 'Quadríceps', 'PERNA'),
  ('Extensão de Quadríceps', 'Estenda as pernas contra a resistência', 'Quadríceps', 'PERNA'),
  ('Flexão de Pernas (Curl)', 'Flexione as pernas contra a resistência', 'Isquiotibiais', 'PERNA'),
  ('Afundo', 'Desça o corpo flexionando os joelhos', 'Quadríceps', 'PERNA'),
  ('Agachamento Hack', 'Agache com os calcanhares elevados', 'Quadríceps', 'PERNA'),
  ('Agachamento Frontal', 'Agache mantendo a barra na frente', 'Quadríceps', 'PERNA'),
  ('Agachamento Sumô', 'Agache com os pés mais afastados', 'Quadríceps', 'PERNA'),
  ('Passada', 'Dê passos longos alternados', 'Quadríceps', 'PERNA'),
  ('Agachamento com Salto', 'Agache e salte explosivamente', 'Quadríceps', 'PERNA'),
  ('Cadeira Extensora', 'Estenda as pernas sentado', 'Quadríceps', 'PERNA'),
  ('Levantamento Terra', 'Levante a barra mantendo as pernas retas', 'Bíceps Femoral', 'PERNA'),
  ('Flexor Horizontal (Máquina)', 'Flexione as pernas deitado', 'Bíceps Femoral', 'PERNA'),
  ('Mesa Flexora', 'Flexione as pernas em posição deitada', 'Bíceps Femoral', 'PERNA'),
  ('Stiff', 'Incline o tronco para frente com as pernas retas', 'Bíceps Femoral', 'PERNA'),
  ('Cadeira Flexora', 'Flexione as pernas sentado', 'Bíceps Femoral', 'PERNA');

-- Peito
INSERT INTO Exercicios (nome, descricao, musculo_trabalhado, categoria) VALUES
  ('Supino Reto', 'Levante a barra em posição horizontal', 'Músculos Pectorais Principais (Pectoralis Major - Clavicular e Sternal)', 'PEITO'),
  ('Supino Inclinado (Parte Superior do Peito)', 'Levante a barra inclinada para cima', 'Pectoralis Major - Clavicular', 'PEITO'),
  ('Supino Declinado', 'Levante a barra inclinada para baixo', 'Pectoralis Major - Sternal', 'PEITO'),
  ('Fly (Crossover)', 'Movimento de abraçar a carga', 'Músculos Pectorais Principais (Pectoralis Major)', 'PEITO'),
  ('Pullover (Peitoral e Costas)', 'Estenda os braços para trás com a barra', 'Pectoralis Major - Clavicular e Dorsais', 'PEITO'),
  ('Supino Máquina', 'Realize o supino em máquina específica', 'Músculos Pectorais Principais (Pectoralis Major)', 'PEITO'),
  ('Flexão de Braços (Paralelas)', 'Flexione os braços entre barras paralelas', 'Pectoralis Major - Sternal', 'PEITO'),
  ('Dips (Peitoral e Tríceps)', 'Realize dips para trabalhar peitoral e tríceps', 'Pectoralis Major - Clavicular e Tríceps', 'PEITO'),
  ('Chest Press', 'Pressione os halteres ou máquina para trabalhar o peitoral', 'Músculos Pectorais Principais (Pectoralis Major)', 'PEITO'),
  ('Chest Fly Máquina', 'Realize o movimento de crossover em máquina', 'Músculos Pectorais Principais (Pectoralis Major)', 'PEITO'),
  ('Peck Deck', 'Utilize a máquina Peck Deck para trabalhar o peitoral', 'Pectoralis Major - Clavicular e Sternal', 'PEITO'),
  ('Apertar Bola na Parede', 'Aperte uma bola contra a parede usando o peitoral', 'Pectoralis Major - Clavicular e Sternal', 'PEITO');

-- Ombro
INSERT INTO Exercicios (nome, descricao, musculo_trabalhado, categoria) VALUES
  ('Desenvolvimento Militar (Parte Frontal do Ombro)', 'Levante a barra sobre a cabeça', 'Parte Frontal do Ombro (Deltóide Anterior)', 'OMBRO'),
  ('Elevação Lateral (Lateral do Ombro)', 'Levante os braços para os lados', 'Deltóide Lateral', 'OMBRO'),
  ('Elevação Frontal (Parte Frontal do Ombro)', 'Levante os braços para frente', 'Parte Frontal do Ombro (Deltóide Anterior)', 'OMBRO'),
  ('Remada Alta (Parte Posterior do Ombro)', 'Puxe a barra em direção ao pescoço', 'Parte Posterior do Ombro (Deltóide Posterior)', 'OMBRO'),
  ('Desenvolvimento Arnold', 'Variação do desenvolvimento que envolve rotação dos braços', 'Ombro (Deltóide Anterior e Posterior)', 'OMBRO'),
  ('Elevação Posterior', 'Levante os braços para trás', 'Parte Posterior do Ombro (Deltóide Posterior)', 'OMBRO'),
  ('Shrugs (Trapézio)', 'Encolha os ombros para trabalhar o trapézio', 'Trapézio', 'OMBRO'),
  ('Rotadores Externos (Ombro)', 'Utilize elásticos para trabalhar os rotadores externos', 'Músculos Rotadores Externos', 'OMBRO'),
  ('Desenvolvimento com Halteres', 'Levante os halteres sobre a cabeça', 'Ombro (Deltóide Anterior e Posterior)', 'OMBRO'),
  ('Elevação Frontal com Halteres', 'Levante os halteres para frente', 'Parte Frontal do Ombro (Deltóide Anterior)', 'OMBRO');

-- Costas
INSERT INTO Exercicios (nome, descricao, musculo_trabalhado, categoria) VALUES
  ('Barra Fixa', 'Levante o corpo até que o queixo passe a barra', 'Latissimus Dorsi', 'COSTAS'),
  ('Puxada Frontal', 'Puxe a barra em direção ao peito', 'Latissimus Dorsi', 'COSTAS'),
  ('Remada Sentada', 'Puxe a barra em direção ao abdômen', 'Latissimus Dorsi', 'COSTAS'),
  ('Pulldown (Latissimus Dorsi)', 'Puxe a barra em direção ao peito', 'Latissimus Dorsi', 'COSTAS'),
  ('Hiperextensão', 'Incline o corpo para trás para trabalhar a parte inferior das costas', 'Erector Spinae', 'COSTAS'),
  ('Remada Curvada', 'Puxe a barra em direção ao abdômen mantendo o tronco inclinado', 'Latissimus Dorsi', 'COSTAS'),
  ('Pull-up (Latissimus Dorsi)', 'Variação de barra fixa para trabalhar os latíssimos', 'Latissimus Dorsi', 'COSTAS'),
  ('T-Bar Row', 'Realize a remada T-Bar para trabalhar as costas', 'Latissimus Dorsi', 'COSTAS'),
  ('Pull-over (Costas e Peitoral)', 'Estenda os braços para trás em movimento amplo', 'Latissimus Dorsi e Peitoral', 'COSTAS'),
  ('Pull-up (Wide Grip)', 'Barra fixa com pegada ampla para enfatizar os latíssimos', 'Latissimus Dorsi', 'COSTAS'),
  ('Remada Unilateral', 'Puxe um halter em direção ao abdômen de forma unilateral', 'Latissimus Dorsi', 'COSTAS');

-- Bíceps
INSERT INTO Exercicios (nome, descricao, musculo_trabalhado, categoria) VALUES
  ('Rosca Direta', 'Levante o peso em direção aos bíceps', 'Bíceps Braquial', 'BICEPS'),
  ('Rosca Alternada', 'Levante os pesos alternadamente', 'Bíceps Braquial', 'BICEPS'),
  ('Martelo (Braquial)', 'Levante os pesos com pegada neutra', 'Braquial', 'BICEPS'),
  ('Scott (Parte Superior do Bíceps)', 'Levante os pesos com apoio nos braços', 'Parte Superior do Bíceps', 'BICEPS'),
  ('21s', 'Realize 21 repetições divididas em diferentes partes do movimento', 'Bíceps Braquial', 'BICEPS'),
  ('Rosca Inversa', 'Levante os pesos com as palmas voltadas para baixo', 'Bíceps Braquial', 'BICEPS'),
  ('Rosca 21', 'Variação de 21s com diferentes segmentos do movimento', 'Bíceps Braquial', 'BICEPS'),
  ('Rosca na Barra Fixa', 'Levante o corpo com as palmas voltadas para você', 'Bíceps Braquial', 'BICEPS'),
  ('Rosca Concentrada', 'Realize a rosca com o cotovelo apoiado na parte interna da coxa', 'Bíceps Braquial', 'BICEPS'),
  ('Rosca 21 com Halteres', 'Variação de 21s utilizando halteres', 'Bíceps Braquial', 'BICEPS'),
  ('Rosca 21 com Barra', 'Variação de 21s com barra reta', 'Bíceps Braquial', 'BICEPS');

-- Tríceps
INSERT INTO Exercicios (nome, descricao, musculo_trabalhado, categoria) VALUES
  ('Tríceps Pulley', 'Estenda os cotovelos com a corda do pulley', 'Tríceps Braquial', 'TRICEPS'),
  ('Tríceps Testa', 'Desça o peso em direção à testa', 'Tríceps Braquial', 'TRICEPS'),
  ('Tríceps Banco', 'Desça o peso atrás da cabeça no banco', 'Tríceps Braquial', 'TRICEPS'),
  ('Paralelas (Tríceps e Peitoral)', 'Desça o corpo entre barras paralelas', 'Tríceps Braquial e Peitoral', 'TRICEPS'),
  ('Tríceps Coice', 'Estenda o cotovelo para trás segurando um halter', 'Tríceps Braquial', 'TRICEPS'),
  ('Dips (Tríceps)', 'Flexione e estenda os cotovelos em barras paralelas', 'Tríceps Braquial', 'TRICEPS'),
  ('Tríceps Corda', 'Estenda os cotovelos usando a corda do pulley', 'Tríceps Braquial', 'TRICEPS'),
  ('Tríceps Mergulho', 'Mergulhe o corpo entre duas barras para trabalhar o tríceps', 'Tríceps Braquial', 'TRICEPS'),
  ('Tríceps Kickback', 'Estenda o cotovelo para trás segurando um halter', 'Tríceps Braquial', 'TRICEPS'),
  ('Tríceps Banco Inclinado', 'Desça o peso atrás da cabeça em banco inclinado', 'Tríceps Braquial', 'TRICEPS'),
  ('Tríceps Francês', 'Desça a barra atrás da cabeça estendendo os cotovelos', 'Tríceps Braquial', 'TRICEPS');

-- Abdômen
INSERT INTO Exercicios (nome, descricao, musculo_trabalhado, categoria) VALUES
  ('Crunch', 'Flexione o tronco em direção aos joelhos', 'Reto abdominal', 'ABDOMEN'),
  ('Prancha Frontal', 'Mantenha o corpo reto em posição de prancha', 'Reto abdominal', 'ABDOMEN'),
  ('Prancha Lateral', 'Mantenha o corpo reto em posição de prancha lateral', 'Reto abdominal', 'ABDOMEN'),
  ('Elevação de Pernas', 'Levante as pernas estendidas em direção ao teto', 'Músculo iliopsoas', 'ABDOMEN'),
  ('Twist Russo', 'Gire o tronco alternadamente em posição sentada', 'Obliquo externo', 'ABDOMEN'),
  ('Bicicleta (Crunch Alternado)', 'Realize um movimento de pedalada deitado', 'Retos abdominais e oblíquos', 'ABDOMEN'),
  ('Reverse Crunch', 'Flexione o quadril em direção ao peito', 'Reto abdominal', 'ABDOMEN'),
  ('Abdominal na Máquina', 'Utilize a máquina específica para realizar abdominais', 'Retos abdominais', 'ABDOMEN'),
  ('Hanging Leg Raise', 'Levante as pernas estendidas pendurado em uma barra', 'Retos abdominais', 'ABDOMEN'),
  ('Prancha Superman', 'Mantenha a posição de prancha elevando braços e pernas', 'Retos abdominais e lombar', 'ABDOMEN'),
  ('Mountain Climber', 'Simule a corrida em posição de prancha', 'Retos abdominais', 'ABDOMEN');

-- Antebraço
INSERT INTO Exercicios (nome, descricao, musculo_trabalhado, categoria) VALUES
  ('Rosca de Punho (Flexão)', 'Flexione os punhos para cima', 'Músculos Flexores do Antebraço', 'ANTEBRACO'),
  ('Rosca de Punho (Extensão)', 'Estenda os punhos para baixo', 'Músculos Extensores do Antebraço', 'ANTEBRACO'),
  ('Pronação e Supinação com Halteres', 'Gire os punhos para dentro e para fora', 'Músculos Pronadores e Supinadores do Antebraço', 'ANTEBRACO'),
  ('Martelo (Antebraço)', 'Levante os pesos com pegada neutra', 'Músculos do Antebraço', 'ANTEBRACO'),
  ('Pinch Grip', 'Aperte um peso entre os dedos e o polegar', 'Músculos do Antebraço', 'ANTEBRACO'),
  ('Wrist Roller', 'Enrole uma corda com peso ao redor de uma barra segurando nas extremidades', 'Músculos do Antebraço', 'ANTEBRACO'),
  ('Farmers Walk', 'Ande segurando pesos nas mãos ao lado do corpo', 'Músculos do Antebraço', 'ANTEBRACO'),
  ('Reverse Wrist Curl', 'Flexione os punhos para cima com as palmas voltadas para baixo', 'Músculos do Antebraço', 'ANTEBRACO'),
  ('Plate Pinch', 'Aperte duas placas de peso entre os dedos', 'Músculos do Antebraço', 'ANTEBRACO'),
  ('Rolling Thunder (Giratório)', 'Gire uma barra com pegada giratória', 'Músculos do Antebraço', 'ANTEBRACO'),
  ('Flexão de Dedos com Elástico', 'Flexione os dedos contra a resistência do elástico', 'Músculos do Antebraço', 'ANTEBRACO');

-- Trapézio
INSERT INTO Exercicios (nome, descricao, musculo_trabalhado, categoria) VALUES
  ('Encolhimento de Ombros', 'Encolha os ombros em direção às orelhas', 'Músculos do Trapézio', 'TRAPEZIO'),
  ('Remada Alta (Trapézio)', 'Puxe a barra em direção ao pescoço mantendo os cotovelos elevados', 'Músculos do Trapézio', 'TRAPEZIO'),
  ('Elevação de Ombros com Halteres', 'Levante os halteres em direção às orelhas', 'Músculos do Trapézio', 'TRAPEZIO'),
  ('Encolhimento com Barra na Frente', 'Encolha os ombros segurando a barra na frente', 'Músculos do Trapézio', 'TRAPEZIO'),
  ('Encolhimento com Barra Atrás', 'Encolha os ombros segurando a barra atrás do corpo', 'Músculos do Trapézio', 'TRAPEZIO'),
  ('Trapézio no Pulley', 'Realize a elevação de ombros usando a máquina pulley', 'Músculos do Trapézio', 'TRAPEZIO'),
  ('Remada Cavalinho', 'Puxe a barra em direção ao abdômen mantendo os cotovelos elevados', 'Músculos do Trapézio', 'TRAPEZIO'),
  ('Face Pull', 'Puxe a corda na altura do rosto para trabalhar o deltóide posterior e trapézio', 'Músculos do Trapézio', 'TRAPEZIO'),
  ('Elevação de Ombros com Corda', 'Levante a corda em direção às orelhas', 'Músculos do Trapézio', 'TRAPEZIO'),
  ('Encolhimento com Halteres', 'Encolha os ombros segurando halteres em cada mão', 'Músculos do Trapézio', 'TRAPEZIO'),
  ('Trapézio na Máquina', 'Utilize a máquina específica para trabalhar o trapézio', 'Músculos do Trapézio', 'TRAPEZIO');
