package tn.esprit.spring;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import tn.esprit.spring.DAO.Entities.Bloc;
import tn.esprit.spring.DAO.Entities.Chambre;
import tn.esprit.spring.DAO.Entities.Foyer;
import tn.esprit.spring.DAO.Repositories.BlocRepository;
import tn.esprit.spring.DAO.Repositories.ChambreRepository;
import tn.esprit.spring.DAO.Repositories.FoyerRepository;
import tn.esprit.spring.Services.Bloc.BlocService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BlocServiceTest {

    @Mock
    private BlocRepository blocRepository;

    @Mock
    private ChambreRepository chambreRepository;

    @Mock
    private FoyerRepository foyerRepository;

    @InjectMocks
    private BlocService blocService;

    private Bloc bloc;
    private Chambre chambre;
    private Foyer foyer;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        // Mock Bloc object
        bloc = new Bloc(1L, "Bloc1", 100, null, new ArrayList<>());

        // Mock Chambre object
        chambre = new Chambre(1L, "Chambre1", 20, null);

        // Mock Foyer object
        foyer = new Foyer();
    }

    @Test
    void testAddOrUpdate() {
        // Prepare the mock behavior
        when(blocRepository.save(any(Bloc.class))).thenReturn(bloc);
        when(chambreRepository.save(any(Chambre.class))).thenReturn(chambre);

        // Call the method under test
        Bloc result = blocService.addOrUpdate(bloc);

        // Verify the interactions and assert the result
        verify(blocRepository, times(1)).save(any(Bloc.class));
        verify(chambreRepository, times(1)).save(any(Chambre.class));

        assertNotNull(result);
        assertEquals(bloc.getNomBloc(), result.getNomBloc());
    }

    @Test
    void testFindAll() {
        List<Bloc> blocList = new ArrayList<>();
        blocList.add(bloc);

        // Mock the behavior
        when(blocRepository.findAll()).thenReturn(blocList);

        // Call the method under test
        List<Bloc> result = blocService.findAll();

        // Assert the result
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(bloc.getNomBloc(), result.get(0).getNomBloc());
    }

    @Test
    void testFindById() {
        // Mock the behavior
        when(blocRepository.findById(1L)).thenReturn(Optional.of(bloc));

        // Call the method under test
        Bloc result = blocService.findById(1L);

        // Assert the result
        assertNotNull(result);
        assertEquals(bloc.getNomBloc(), result.getNomBloc());
    }

    @Test
    void testDeleteById() {
        // Mock the behavior
        when(blocRepository.findById(1L)).thenReturn(Optional.of(bloc));

        // Call the method under test
        blocService.deleteById(1L);

        // Verify the interactions
        verify(chambreRepository, times(1)).deleteAll(anyList());
        verify(blocRepository, times(1)).delete(any(Bloc.class));
    }

    @Test
    void testAffecterChambresABloc() {
        List<Long> chambreIds = new ArrayList<>();
        chambreIds.add(1L);

        // Mock the behavior
        when(blocRepository.findByNomBloc("Bloc1")).thenReturn(bloc);
        when(chambreRepository.findByNumeroChambre(1L)).thenReturn(chambre);

        // Call the method under test
        Bloc result = blocService.affecterChambresABloc(chambreIds, "Bloc1");

        // Verify the interactions and assert the result
        verify(chambreRepository, times(1)).save(any(Chambre.class));
        assertNotNull(result);
        assertEquals(bloc.getNomBloc(), result.getNomBloc());
    }

    @Test
    void testAffecterBlocAFoyer() {
        // Mock the behavior
        when(blocRepository.findByNomBloc("Bloc1")).thenReturn(bloc);
        when(foyerRepository.findByNomFoyer("Foyer1")).thenReturn(foyer);
        when(blocRepository.save(any(Bloc.class))).thenReturn(bloc);

        // Call the method under test
        Bloc result = blocService.affecterBlocAFoyer("Bloc1", "Foyer1");

        // Verify the interactions and assert the result
        verify(blocRepository, times(1)).save(any(Bloc.class));
        assertNotNull(result);
        assertEquals(bloc.getFoyer().getNomFoyer(), "Foyer1");
    }
}
