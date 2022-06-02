package api.services.impl;

import api.models.Position;
import api.repositories.IPositionRepository;
import api.services.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements IPositionService {
    @Autowired
    IPositionRepository iPositionRepository;

    @Override
    public List<Position> findAll() {
        return this.iPositionRepository.findAll();
    }
}
