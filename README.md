# FallbackDFA-FDFA
A fallback deterministic finite automaton with actions (FDFA) implementation in Java.

### 1. Objective
In this project a fallback deterministic finite automaton with actions
(FDFA) abstract data type was implemented. 

Recall that an FDFA is a sextuple (Q, Σ, δ, q0, F, A): Q is a non-empty, finite set of states; Σ is non-empty, finite set of symbols (an alphabet); δ : Q×Σ −→ Q
is the transition function; q0 ∈ Q is the start state; F ⊆ Q is the set of accept states; and A is
function that maps every state in Q to an action.

Given a description of an NFA, an equivalent DFA is Constructed.

### 2 Requirements
- The following assumptions are made for simplicity.
  * The alphabet Σ is always the binary alphabet {0, 1}.
  * The set of states Q is always of the form {0, . . ., n}, for some n ∈ N.
  * The start state is always state 0.
  * A maps each state to a binary string; the action is to print this string.
-  Two functions were implemented: fdfa and run.
  * fdfa (which could be a class constructor) takes one parameter which is a string description of an FDFA and returns (or constructs) an FDFA instance as per the description.
  * run simulates the operation of the constructed FDFA on a given binary string. For example, running the above FDFA on the string 1011100 produces the output 1000.
- A string describing an FDFA is of the form P#S, where P is a prefix representing both
the transition function δ and the action function A and S is a suffix representing the set
F of accept state.
- P is a semicolon-separated sequence of quadruples. Each quadruple is a comma-separated
sequence of items; the first three items are states and the fourth is a binary string. A
quadruple i, j, k, s means that δ(i, 0) = j, δ(i, 1) = k, and A(i) = s.
- S is a comma-separated sequence of states.
- For example, consider the FDFA for which the state diagram appears below. Suppose
that, for state i, A(i) is the two-bit binary representation of i. Thus, such an FDFA may
have the following string representation.

**0,0,1,00;1,2,1,01;2,0,3,10;3,3,3,11#0,1,2**

![DFA](https://github.com/abdallahaymaan/NFA_to_DFA/blob/main/DFA.JPG)
