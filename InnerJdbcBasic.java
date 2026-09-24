// class JdbcBasic {
//    public static void main(String[] args) {
//     //  Car c=new Car();
//     //   c.drive();
//    Car c=new Car(new DesialEngien());
//     c.drive();
   

//    }
// }
// //This Example of Tight Couple 
// // class Engine{
// //     void start(){
// //         System.out.println("Engine Start");
// //     }
// // }
// // class Car{
// //     Engine e=new Engine();
// //     void drive(){
// //         e.start();
// //         System.out.println("You can Drive");
// //     }
// // }


// Loosly associations
// interface Engine{
//    void start();
// }
// class DesialEngien implements Engine{
//    public void  start(){
//       System.out.println("Desial Engine Start");
//    }
// }
// class PetrolEngien implements Engine{
//    public void start(){
//       System.out.println("Petrol Engine Start");
//    }
// }
// class CngEngien implements Engine{
//    public void start(){
//       System.out.println("CNG Engine Start");
//    }
// }
// class Car{
//    Engine e;
//    Car(Engine e){
//       this.e=e;
//    }
//    void drive(){
//       e.start();
//    }
// }

