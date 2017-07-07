import org.junit.*;
import static org.junit.Assert.*;

public class MemberTest {
  @Test
  public void Member_instantiatesCorrectly_true() {
    Member testMember = new Member("steve@zaske1.com");
    assertEquals(true, testMember instanceof Member);
  }

  @Test
  public void email_returnsMemberEmail() {
    Member testMember = new Member("steve@zaske2.com");
    assertEquals("steve@zaske2.com", testMember.email());
  }

  @Test
  public void getAll_returnsAllMembers_3() {
    Member.clearMembers();
    Member testMember1 = new Member("steve@zaske3.com");
    Member testMember2 = new Member("miketyson@mma.com");
    Member testMember3 = new Member("billg@microsoft.com");
    assertEquals(3, Member.getAll().size());
  }

  @Test
  public void clearMembers_clearsAllExistingMembers_0() {
    Member testMember1 = new Member("steve@zaske3.com");
    Member testMember2 = new Member("miketyson@mma.com");
    Member testMember3 = new Member("billg@microsoft.com");
    Member.clearMembers();
    assertEquals(0, Member.getAll().size());
  }

  @Test
  public void find_returnsCorrectMember_testMember3() {
    Member.clearMembers();
    Member testMember1 = new Member("steve@zaske3.com");
    Member testMember2 = new Member("miketyson@mma.com");
    Member testMember3 = new Member("billg@microsoft.com");
    assertEquals(testMember3, Member.find(3));
  }

}
