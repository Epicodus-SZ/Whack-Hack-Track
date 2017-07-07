import org.junit.*;
import static org.junit.Assert.*;

public class TeamTest {
  @Test
  public void Team_instantiatesCorrectly_true() {
    Team testTeam = new Team("Flogging Mollys");
    assertEquals(true, testTeam instanceof Team);
  }

  @Test
  public void name_returnsTeamName_FlogginMollys() {
    Team testTeam = new Team("Flogging Mollys");
    assertEquals("Flogging Mollys", testTeam.name());
  }

  @Test
  public void clearTeams_resetsNumOfTeamsToZero_0() {
    Team testTeam1 = new Team("Flogging Mollys");
    Team testTeam2 = new Team("Five Bunnys");
    Team.clearTeams();
    assertEquals(0, Team.getAll().size());
  }

  @Test
  public void getAll_returnsAllTeams_3() {
    Team.clearTeams();
    Team testTeam1 = new Team("Flogging Mollys");
    Team testTeam2 = new Team("Five Bunnys");
    Team testTeam3 = new Team("The Snacks Overflow");
    assertEquals(3, Team.getAll().size());
  }

  @Test
  public void addMember_AddsMemberToTeam_true() {
    Team testTeam = new Team("Flogging Mollys");
    Member testMember = new Member("steve@zaske.com");
    testTeam.addMember(testMember);
    assertEquals(true, testTeam.allMembers().contains(testMember));
  }

  @Test
  public void addMember_DoesNotAddDuplicateMembersToTeam_1() {
    Team testTeam = new Team("Flogging Mollys");
    Member testMember = new Member("steve@zaske.com");
    testTeam.addMember(testMember);
    testTeam.addMember(testMember);
    assertEquals(1, testTeam.allMembers().size());
  }

  @Test
  public void allMembers_returnsAllMembers() {
    Team testTeam = new Team("Five Bunnys");
    Member default1 = new Member("steve@zaske.com");
    Member default2 = new Member("billg@microsoft.com");
    testTeam.addMember(default1);
    testTeam.addMember(default2);
    assertEquals(2, testTeam.allMembers().size());
  }

  @Test
  public void reset_ClearsTheListOfMembers() {
    Team testTeam = new Team("Five Bunnys");
    Member default1 = new Member("steve@zaske.com");
    Member default2 = new Member("billg@microsoft.com");
    testTeam.addMember(default1);
    testTeam.addMember(default2);
    testTeam.clearMembers();
    assertEquals(0, testTeam.allMembers().size());
  }

}
