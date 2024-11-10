enum Instruction {
    TURN_ON,
    TURN_OFF,
    TOGGLE
}

record InstructionResult(Instruction instruction, int[] start, int[] end) {
}
// for my notes TODO: need to undersand what is record
// class InstructionResult {
//    private final Instruction instruction;
//    private final int[] start;
//    private final int[] end;
//
//    public InstructionResult(Instruction instruction, int[] start, int[] end) {
//        this.instruction = instruction;
//        this.start = start;
//        this.end = end;
//    }
//
//    public Instruction getInstruction() {
//        return instruction;
//    }
//
//    public int[] getStart() {
//        return start;
//    }
//
//    public int[] getEnd() {
//        return end;
//    }
//}