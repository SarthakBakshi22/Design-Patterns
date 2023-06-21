# Template Method Pattern

Template Method Pattern to determine course work required for different stream students to complete degree requirements

- Requirements that need to be considered and fulfilled to complete the degree
  
    - Every student must have one from A, C, G, H, L, M, N, O, P, S, Y, and satisfy Foreign Language.
    - If you take a J course, you automatically get both C and O.
    - If you take a B course, you automatically get both S and Y.
    - A course with a C, O, or J can double count with one of the other Gened's if the course carries other Gened's. 
    - If the course has more than one of the A, G, H, L, M, N, P, S, Y, (B = S & Y), only one can be used to meet the student's Gened requirement--the choice of which one is optimized automatically to get as many Gened's out of the combination of courses taken.
    -Foreign language: If the student is in CS or Nursing, they only need to take one FL1, FL2, or FL3 course. Engineering students do not need any FL course. All other students have to take FL1, FL2, FL3 in one language, or have to take FL1 and FL2 in 2 separate languages.
