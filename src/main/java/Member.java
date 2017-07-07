import java.util.ArrayList;
import java.util.List;

public class Member {
  private String mEmail;
  private static List<Member> instances = new ArrayList<Member>();
  private int mId;

  public Member(String email){
    mEmail = email;
    instances.add(this);
    mId = instances.size();
  }

  public String email(){
    return mEmail;
  }

  public static List<Member> getAll(){
    return instances;
  }

  public int id(){
    return mId;
  }

  public static Member find(int id){
    return instances.get(id-1); //minus 1 because the ID is based on size, but the location in array is zero-based
  }

  public static void clearMembers(){
    instances.clear();
  }
}
