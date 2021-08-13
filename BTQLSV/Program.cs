using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace CsharpTutorial
{
    class Student
    {
        private int ID;
        public int id { get { return ID; } set { ID =value; } }
        private string Name;
        public string name { get { return Name; } set { Name = value; } }
        private string Sex;
        public string sex{ get { return Sex; } set { Sex = value; } }
        private int Age; 
        public int age{ get { return Age; } set { Age = value; } }
        private double DiemToan;
        public double diemToan{ get { return DiemToan; } set { DiemHoa = value; } }
        private double DiemLy;
        public double diemLy{ get { return DiemLy; } set { DiemLy = value; } }
        private double DiemHoa; 
        public double diemHoa{ get { return DiemHoa; } set { DiemHoa = value; } }
        private double DiemTB;
        public double diemTB { get { return DiemTB;} set { DiemTB = value; } }
        private string HocLuc;
        public string hocLuc{ get {return HocLuc;} set { HocLuc = value; } }
        public List<Student> ListStudent = new List<Student>();

        public Student()
        {

        }
        public Student(int id, string name, string sex, int age, double diemtoan, double diemly, double diemhoa,double dtb)
        {
            this.ID = id;
            this.Name = name;
            this.Age = age;
            this.Sex = sex;
            this.DiemToan = diemtoan;
            this.DiemHoa = diemhoa;
            this.DiemLy = diemly;
            this.DiemTB = dtb;
            this.HocLuc = ktHocLuc(this.DiemTB);
        }
        public string ktHocLuc(double dtb)
        {
            if (dtb >= 8) return "Gioi";
            else if (dtb < 8 && dtb >= 6.5) return "Kha";
            else if (dtb < 6.5 && dtb >= 5) return "Trung binh";
            else if (dtb < 5) return "Yeu";
            return null;
        }
        public List<Student> getAllStudent()
        {
            return ListStudent;
        }
        public void showInfor()
        {
            Console.WriteLine("--------------------------------");
            Console.WriteLine("ID : "+this.ID);
            Console.WriteLine("Name : " + this.Name);
            Console.WriteLine("Sex : " + this.Sex);
            Console.WriteLine("Age : " + this.Age);
            Console.WriteLine("Hoc luc : " + this.HocLuc);
            Console.WriteLine("--------------------------------");
        }
        public void showAllStudent()
        {
            if (ListStudent.Count > 0)
            {
                foreach (Student sv in ListStudent)
                {
                    Console.WriteLine("{0, -5} {1, -20} {2, -5} {3, 5} {4, 5} {5, 5} {6, 5} {7, 10} {8, 10}",
                    "ID", "Name", "Sex", "Age", "Toan", "Ly", "Hoa", "Diem TB", "Hoc Luc");
                    Console.WriteLine("{0, -5} {1, -20} {2, -5} {3, 5} {4, 5} {5, 5} {6, 5} {7, 10} {8, 10}",
                                          sv.ID, sv.Name, sv.Sex, sv.Age, sv.DiemToan, sv.DiemLy, sv.DiemHoa,
                                          sv.DiemTB, sv.HocLuc);
                }
            }
        }
        public void insertStudent(){
            int id = ListStudent.Count + 1;
            Console.Write("Nhap ten : ");
            string name = Console.ReadLine();
            Console.Write("Nhap gioi tinh : ");
            string sex = Console.ReadLine();
            Console.Write("Nhap tuoi : ");
            int age = int.Parse(Console.ReadLine());
            Console.Write("Nhap diem toan : ");
            double diemtoan = double.Parse(Console.ReadLine());
            Console.Write("Nhap diem ly : ");
            double diemly = double.Parse(Console.ReadLine());
            Console.Write("Nhap hoa : ");
            double diemhoa = double.Parse(Console.ReadLine());
            Console.Write("Nhap diem trung binh : ");
            double diemtb = double.Parse(Console.ReadLine());
            ListStudent.Add(new Student(id, name, sex, age, diemtoan, diemly, diemhoa, diemtb));
        }
        public void updateStudent(int id)
        {
            foreach (Student st in ListStudent)
            {
                if (st.ID == id)
                {
                    Console.Write("Nhap ten : ");
                    string name = Console.ReadLine();
                    Console.Write("Nhap gioi tinh : ");
                    string sex = Console.ReadLine();
                    Console.Write("Nhap tuoi : ");
                    int age = int.Parse(Console.ReadLine());
                    Console.Write("Nhap diem toan : ");
                    double diemtoan = double.Parse(Console.ReadLine());
                    Console.Write("Nhap diem ly : ");
                    double diemly = double.Parse(Console.ReadLine());
                    Console.Write("Nhap hoa : ");
                    double diemhoa = double.Parse(Console.ReadLine());
                    Console.Write("Nhap diem trung binh : ");
                    double diemtb = double.Parse(Console.ReadLine());
                    st.name = name;
                    st.sex = sex;
                    st.age = age;
                    st.diemHoa = diemhoa;
                    st.diemToan = diemtoan;
                    st.diemLy = diemly;
                    st.diemTB = diemtb;
                    st.hocLuc = ktHocLuc(diemtb);
                }
            }
        }
        public void deteleStudent(int id)
        {
            Student s = findID(id);
            ListStudent.Remove(s);
        }
        public void findByName(string name)
        {
            foreach(Student s in ListStudent){
                if (s.name == name)
                {
                    s.showInfor();
                    break;
                }
            }
        }
        public Student findID(int id)
        {
            foreach(Student st in ListStudent){
                if(st.ID == id) return st;
            }
            return null;
        }
        public void sortGPA()
        {
            for (int i = 0; i < ListStudent.Count; i++)
            {
                for (int j = 1; j < ListStudent.Count; j++)
                {
                    if (ListStudent[i].diemTB < ListStudent[j].diemTB)
                    {
                        Student tmp = ListStudent[i];
                        ListStudent[i] = ListStudent[j];
                        ListStudent[j] = tmp;
                    }
                }
            }
        }
    }
    
    class Program
    {
        static void Main(string[] args)
        {
            int? choose = null;
            int id = 0;
            Student st = new Student();
            do{
               Console.WriteLine("\nCHUONG TRINH QUAN LY SINH VIEN C#");
               Console.WriteLine("*************************MENU**************************");
               Console.WriteLine("**  1. Them sinh vien.                               **");
               Console.WriteLine("**  2. Cap nhat thong tin sinh vien boi ID.          **");
               Console.WriteLine("**  3. Xoa sinh vien boi ID.                         **");
               Console.WriteLine("**  4. Tim kiem sinh vien theo ten.                  **");
               Console.WriteLine("**  5. Sap xep sinh vien theo diem trung binh (GPA). **");
               Console.WriteLine("**  6. Hien thi danh sach sinh vien.                 **");
               Console.WriteLine("**  0. Thoat                                         **");
               Console.WriteLine("*******************************************************");
               Console.Write("Nhap tuy chon: ");
               choose = int.Parse(Console.ReadLine());
               switch (choose)
               {
                   case 1:
                       st.insertStudent();
                       break;
                   case 2:
                       Console.Write("Nhap id ban muon cap nhat : ");
                       id = int.Parse(Console.ReadLine());
                       st.updateStudent(id);
                       break;
                   case 3:
                       Console.Write("Nhap id ban muon xoa : ");
                       id = int.Parse(Console.ReadLine());
                       st.deteleStudent(id);
                       break;
                   case 4:
                       Console.Write("Nhap ten sinh vien can tim : ");
                       string name = Console.ReadLine();
                       st.findByName(name);
                       break;
                   case 5:
                       st.sortGPA();
                       break;
                   case 6:
                       st.showAllStudent();
                       break;

               }

            }while(choose != 0);
        }
    }
}
