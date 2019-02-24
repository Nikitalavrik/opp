with Ada.Text_IO;
with Ada.Integer_Text_IO;
with Ada.Float_Text_IO;
with Ada.Numerics.Discrete_Random;

package body Data is

    --declare range of random value.
    type Random_Value is range 1..20;
   
    package Rand_Int is new Ada.Numerics.Discrete_Random(Random_Value);
    package Float_IO is new Ada.Text_IO.Float_IO(Float);
    use Rand_Int;
   
    --initialize random value.
    gen: Rand_Int.Generator;

    function Get_Float return Float is
        F: Float;
    begin
        Ada.Float_Text_IO.Get(F);
        return F;
    end Get_Float;

    procedure Vector_Input(vec: out Vector; str: in String) is
    begin
        for i in 1..N loop
            Ada.Text_IO.Put(str);
            Ada.Text_IO.Put(" column - ");
            Ada.Text_IO.Put_Line(Integer'Image(i));
            vec(i) := Get_Float;
        end loop;
    end Vector_Input;

    procedure Matrix_Input(matr: out Matrix; str: in String) is
    begin
        for i in 1..N loop
            Ada.Text_IO.Put(str);
            Ada.Text_IO.Put(" row - ");
            Ada.Text_IO.Put_Line(Integer'Image(i));
            Vector_Input(matr(i), str);
        end loop;
    end Matrix_Input;

    procedure Vector_Output(vec: in Vector) is
    begin
        Ada.Text_IO.Put("|");
        for i in vec'Range loop
            Float_IO.Put(vec(i), Aft=>1, Exp=>0);
            if i /= vec'Last then
                Ada.Text_IO.Put(", ");
            end if;
        end loop;
        Ada.Text_IO.Put_Line("|");
    end Vector_Output;

    procedure Matrix_Output(matr: in Matrix) is
    begin
        for i in 1..N loop
            Vector_Output(matr(i));
        end loop;
        Ada.Text_IO.New_Line;
    end Matrix_Output;
   
    procedure Generate_Vector(vec: out Vector) is
    begin
        for i in 1..N loop
            Rand_Int.Reset(gen);
            vec(i) := FLOAT(Rand_Int.Random(gen));
        end loop;
    end Generate_Vector;
   
    procedure Generate_Matrix(matr: out Matrix) is
    begin
        for i in 1..N loop
            Generate_Vector(matr(i));
        end loop;
    end Generate_Matrix;
   
    procedure Fill_Vector(vec: out Vector; by: in Float := 0.0) is
    begin
        for i in 1..N loop
            vec(i) := by;
        end loop;
    end Fill_Vector;
   
    procedure Fill_Matrix(mat: out Matrix; by: in Float := 0.0) is
    begin
        for i in 1..N loop
            Fill_Vector(mat(i), by);
        end loop;
    end Fill_Matrix;

    function Trans(matr: in Matrix) return Matrix is
        tmp_matr: Matrix;
    begin
        Fill_Matrix(tmp_matr);
        for i in 1..N loop
            for j in 1..N loop
                tmp_matr(i)(j) := matr(j)(i);
            end loop;
        end loop;
        return tmp_matr;
    end Trans;

    function "*"(Op_1, Op_2: Vector) return Float is
        Result: Float := 0.0;
    begin
        for i in Op_1'Range loop
            Result := Result + Op_1(i) * Op_2(i);
        end loop;
      
        return Result;
    end "*";
   
    function "*"(Op_1, Op_2: Matrix) return Matrix is
        Result: Matrix;
    begin
        Fill_Matrix(Result);
        for i in 1..N loop
            for j in 1..N loop
                for k in 1..N loop
                Result(i)(j) := Result(i)(j) + Op_1(i)(k)*Op_2(k)(j);
                end loop;
            end loop;
        end loop;
        return Result;
    end "*";
   
    function "+"(Op_1, Op_2: Vector) return Vector is
        resultV: Vector;
    begin
        for i in Op_1'Range loop
            resultV(i) := Op_1(i) + Op_2(i);
        end loop;
      
        return resultV;
    end "+";
  
    function "+"(Op_1, Op_2: Matrix) return Matrix is
        Result: Matrix;
    begin
        for i in 1..N loop
            Result(i) := Op_1(i) + Op_2(i);
        end loop;
      
        return Result;
    end "+";
   
    function "*"(Op_1: Matrix; Op_2: Vector) return Vector is
        Result: Vector;
    begin    
        Fill_Vector(Result);
        for i in 1..N loop
            for j in 1..N loop
                Result(i) := Result(i) + Op_1(i)(j) * Op_2(i);
            end loop;
        end loop;
      
        return Result;
    end "*";
   
    function "*"(Op_1: Vector; Op_2: Matrix) return Vector is
        begin
        return Op_2 * Op_1;
    end "*";
   
    procedure Func1(B, C, D: in Vector; MD, ME: in Matrix; A: out Vector) is
    begin
        A := B + C + D * (MD * ME);
    end Func1;
   
    procedure Func2(MG, MK, ML: in Matrix; MF: in out Matrix) is
    begin
        MF := Trans(MG) + MK * ML;
    end Func2;
   
    procedure Func3(P, S: in Vector; MO, MS, MR: in Matrix; T: out Vector) is
    begin
        T := MO * P + (MR * MS) * S;
    end Func3;

end Data;