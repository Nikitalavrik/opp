generic N: Integer;

package Data is

    type Vector is array(1..N) of Float;
    type Matrix is array(1..N) of Vector;

    --transpose matrix.
    function Trans(matr: in Matrix) return Matrix;

    --functions that allowed by option
    procedure Func1(B, C, D: in Vector; MD, ME: in Matrix; A: out Vector);
    procedure Func2(MG, MK, ML: in Matrix; MF: in out Matrix);
    procedure Func3(P, S: in Vector; MO, MS, MR: in Matrix; T: out Vector);
    
    --output vectors and matrix.
    procedure Vector_Output(vec: in Vector);
    procedure Matrix_Output(matr: in Matrix);

    --generate random vector and matrix.
    procedure Generate_Vector(vec: out Vector);
    procedure Generate_Matrix(matr: out Matrix);

    --generate vector and matrix with fill value.
    procedure Fill_Matrix(mat: out Matrix; by: in Float := 0.0);
    procedure Fill_Vector(vec: out Vector; by: in Float := 0.0);
    
    --user input vector and matrix.
    procedure Vector_Input(vec: out Vector; str: in String);
    procedure Matrix_Input(matr: out Matrix; str: in String);
end Data;