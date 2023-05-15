import org.junit.jupiter.api.Test;

import static org.example.Vote.canVote;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class VoteTest {


    @Test
    void mustVoteTest() {
        assertEquals("Voto obrigatório", canVote(18));
        assertEquals("Voto obrigatório", canVote(70));
        assertEquals("Voto obrigatório", canVote(35));

    }

    @Test
    void voteOptionalTest() {
        assertEquals("Voto facultativo", canVote(16));
        assertEquals("Voto facultativo", canVote(17));
        assertEquals("Voto facultativo", canVote(71));
        assertEquals("Voto facultativo", canVote(99));
    }

    @Test
    void cantVoteTest() {
        assertEquals("Sem direito a votar", canVote(15));
        assertEquals("Sem direito a votar", canVote(5));
        assertEquals("Sem direito a votar", canVote(0));
        assertEquals("Sem direito a votar", canVote(-1));
    }

    @Test
    void mustVoteTestWithAssertAll() {
        assertAll(
                () -> assertEquals("Voto obrigatório", canVote(18)),
                () -> assertEquals("Voto obrigatório", canVote(70)),
                () -> assertEquals("Voto obrigatório", canVote(35))
                );
    }
}
