import { Router } from 'express';

const router = Router();

// Banco em memória (troque por DB real depois)
let appointments: any[] = [];
let idCounter = 1;

// Listar todos
router.get('/appointments', (req, res) => {
  res.json(appointments);
});

// Criar novo
router.post('/appointments', (req, res) => {
  const newAppointment = { id: idCounter++, ...req.body };
  appointments.push(newAppointment);
  res.status(201).json(newAppointment);
});

// Atualizar
router.put('/appointments/:id', (req, res) => {
  const id = parseInt(req.params.id, 10);
  const index = appointments.findIndex(a => a.id === id);
  if (index === -1) {
    return res.status(404).json({ error: 'Agendamento não encontrado' });
  }
  appointments[index] = { ...appointments[index], ...req.body };
  res.json(appointments[index]);
});

// Deletar
router.delete('/appointments/:id', (req, res) => {
  const id = parseInt(req.params.id, 10);
  appointments = appointments.filter(a => a.id !== id);
  res.status(204).send();
});

export default router;
