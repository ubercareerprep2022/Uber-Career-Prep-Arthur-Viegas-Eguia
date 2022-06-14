import java.util.List;
import java.util.LinkedList;
public class OrganizationStructureExercise1 {
  public Employee ceo;

  public static class Employee {
      public String name;
      public String title;
      public List<Employee> directReports;
  }
  private void printNumLevels(){
    LinkedList<Employee> queue = new LinkedList<>();
    LinkedList <Employee> nextLevel = new LinkedList<>();
    int count = 0;
    queue.add(ceo);
    while (queue.peek() != null){
      for(int i = 0; i < queue.size(); i ++){
        if(queue.get(i).directReports != null){
          for(Employee reports : queue.get(i).directReports){
            nextLevel.add(reports);
          }
        }
      }
        count++;
        queue = nextLevel;
        nextLevel = new LinkedList<>();
      }
    System.out.println(count);
  }
        while(!queue.isEmpty()){
          Employee employee = queue.removeFirst();
          System.out.println("Name: "+employee.name+" Title: "+employee.title);
        }
        System.out.print("\n");
        queue = nextLevel;
        nextLevel = new LinkedList<>();
      }
  }
}
