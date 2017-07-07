import java.util.ArrayList;
import java.util.List;

public class Member {
  private String mName;
  private String mEmail;
  private static List<Member> instances = new ArrayList<Member>();
  private int mId;

  public Member(String email){
    mEmail = email;
    instances.add(this);
    mId = instances.size();
  }

  public static List<Member> getAll(){
    return instances;
  }

}
