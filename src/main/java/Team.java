import java.util.ArrayList;
import java.util.List;

public class Team {
  private String mName;
  private static List<Team> instances = new ArrayList<Team>();
  private int mId;
  private List<Member> mMembers;

  public Team(String name){
    mName = name;
    instances.add(this);
    mId = instances.size();
    mMembers = new ArrayList<Member>();
  }

  public String name(){
    return mName;
  }

  public int id(){
    return mId;
  }

  public List<Member> allMembers(){
    return mMembers;
  }

  public static List<Team> getAll(){
    return instances;
  }

  public void addMember(Member member){
    //if check so we don't duplicate members on a team
    if (!mMembers.contains(member)){
      mMembers.add(member);
    }
  }

  public static Team find(int id){
    return instances.get(id-1); //minus 1 because the ID is based on size, but the location in array is zero-based
  }

  public void clearMembers(){
    mMembers.clear();
  }

  public static void clearTeams(){
    instances.clear();
  }
}
