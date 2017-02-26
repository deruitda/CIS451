import org.junit.Assert;
import org.junit.Test;

import static edu.gvsu.dlunit.DLUnit.*;

/**
 * Test Cases for Single-Cycle CPU Control Unit
 */
public class ControlTests {

  public static class OpCodes {
    public static final int ADD   = 0;
    public static final int ADDU  = 0;
    public static final int ADDI  = 8;
    public static final int ADDIU = 9;
    public static final int AND   = 0;
	public static final int ANDI  = 12;
	public static final int BEQ   = 4;
	public static final int BNE   = 5;
	public static final int HALT  = 32;
	public static final int J     = 2;
	public static final int JAL   = 3;
	public static final int JR    = 0;
	public static final int LW    = 35;
	public static final int LUI   = 15;
	public static final int NOR   = 0;
	public static final int OR    = 0;
	public static final int ORI   = 13;
	public static final int SLT   = 0;
	public static final int SLTU  = 0;
	public static final int SLTI  = 10;
	public static final int SLTIU = 11;
	public static final int SW    = 43;
	public static final int SUB   = 0;
	public static final int SUBU  = 0;
	public static final int XOR   = 0;
	public static final int XORI  = 14;
  }
  
  public static class FuncCodes {
    public static final int ADD   = 32;
    public static final int ADDU  = 33;
    public static final int ADDI  = 0;
    public static final int ADDIU = 0;
    public static final int AND   = 36;
	public static final int ANDI  = 0;
	public static final int BEQ   = 0;
	public static final int BNE   = 0;
	public static final int HALT  = 0;
	public static final int J     = 0;
	public static final int JAL   = 0;
	public static final int JR    = 8;
	public static final int LW    = 0;
	public static final int LUI   = 0;
	public static final int NOR   = 39;
	public static final int OR    = 37;
	public static final int ORI   = 0;
	public static final int SLT   = 42;
	public static final int SLTU  = 43;
	public static final int SLTI  = 0;
	public static final int SLTIU = 0;
	public static final int SW    = 0;
	public static final int SUB   = 34;
	public static final int SUBU  = 35;
	public static final int XOR   = 38;
	public static final int XORI  = 0;
	  
  }


  @Test
  public void testADD() {
    setPinUnsigned("OpCode", OpCodes.ADD);
    setPinUnsigned("functionCode", FuncCodes.ADD);
    run();
    Assert.assertEquals("ADD: RegDest", false, readPin("RegDest"));
    Assert.assertEquals("ADD: Branch", false, readPin("Branch"));
	Assert.assertEquals("ADD: MemRead", false, readPin("MemRead"));
	Assert.assertEquals("ADD: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("ADD: ALUop", 0, readPinUnsigned("ALUop"));
    Assert.assertEquals("ADD: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("ADD: ALUsrc", false, readPin("ALUsrc"));
	Assert.assertEquals("ADD: RegWrite", true, readPin("RegWrite"));
	Assert.assertEquals("ADD: Jump", false, readPin("Jump"));
	Assert.assertEquals("ADD: jal", false, readPin("jal"));
	Assert.assertEquals("ADD: jr", false, readPin("jr"));
	Assert.assertEquals("ADD: bne", false, readPin("bne"));
	Assert.assertEquals("ADD: Halt", false, readPin("Halt"));
	Assert.assertEquals("ADD: ZeroExtend", false, readPin("ZeroExtend"));
  }

  @Test
  public void testADDU() {
    setPinUnsigned("OpCode", OpCodes.ADDU);
    setPinUnsigned("functionCode", FuncCodes.ADDU);
    run();
    Assert.assertEquals("ADDU: RegDest", false, readPin("RegDest"));
    Assert.assertEquals("ADDU: Branch", false, readPin("Branch"));
	Assert.assertEquals("ADDU: MemRead", false, readPin("MemRead"));
	Assert.assertEquals("ADDU: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("ADDU: ALUop", 0, readPinUnsigned("ALUop"));
    Assert.assertEquals("ADDU: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("ADDU: ALUsrc", false, readPin("ALUsrc"));
	Assert.assertEquals("ADDU: RegWrite", true, readPin("RegWrite"));
	Assert.assertEquals("ADDU: Jump", false, readPin("Jump"));
	Assert.assertEquals("ADDU: jal", false, readPin("jal"));
	Assert.assertEquals("ADDU: jr", false, readPin("jr"));
	Assert.assertEquals("ADDU: bne", false, readPin("bne"));
	Assert.assertEquals("ADDU: Halt", false, readPin("Halt"));
	Assert.assertEquals("ADDU: ZeroExtend", false, readPin("ZeroExtend"));
  }

  @Test
  public void testADDI() {
    setPinUnsigned("OpCode", OpCodes.ADDI);
    setPinUnsigned("functionCode", FuncCodes.ADDI);
    run();
    Assert.assertEquals("ADDI: RegDest",  true, readPin("RegDest"));
    Assert.assertEquals("ADDI: Branch",   false, readPin("Branch"));
	Assert.assertEquals("ADDI: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("ADDI: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("ADDI: ALUop", 0, readPinUnsigned("ALUop"));
    Assert.assertEquals("ADDI: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("ADDI: ALUsrc",   true, readPin("ALUsrc"));
	Assert.assertEquals("ADDI: RegWrite", true, readPin("RegWrite"));
	Assert.assertEquals("ADDI: Jump",     false, readPin("Jump"));
	Assert.assertEquals("ADDI: jal",      false, readPin("jal"));
	Assert.assertEquals("ADDI: jr",       false, readPin("jr"));
	Assert.assertEquals("ADDI: bne",      false, readPin("bne"));
	Assert.assertEquals("ADDI: Halt",     false, readPin("Halt"));
	Assert.assertEquals("ADDI: ZeroExtend", false, readPin("ZeroExtend"));
  }
  
  @Test
  public void testADDIU() {
    setPinUnsigned("OpCode", OpCodes.ADDIU);
    setPinUnsigned("functionCode", FuncCodes.ADDIU);
    run();
    Assert.assertEquals("ADDIU: RegDest",  true, readPin("RegDest"));
    Assert.assertEquals("ADDIU: Branch",   false, readPin("Branch"));
	Assert.assertEquals("ADDIU: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("ADDIU: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("ADDIU: ALUop", 0, readPinUnsigned("ALUop"));
    Assert.assertEquals("ADDIU: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("ADDIU: ALUsrc",   true, readPin("ALUsrc"));
	Assert.assertEquals("ADDIU: RegWrite", true, readPin("RegWrite"));
	Assert.assertEquals("ADDIU: Jump",     false, readPin("Jump"));
	Assert.assertEquals("ADDIU: jal",      false, readPin("jal"));
	Assert.assertEquals("ADDIU: jr",       false, readPin("jr"));
	Assert.assertEquals("ADDIU: bne",      false, readPin("bne"));
	Assert.assertEquals("ADDIU: Halt",     false, readPin("Halt"));
	Assert.assertEquals("ADDIU: ZeroExtend", false, readPin("ZeroExtend"));
  }
  
  @Test
  public void testAND() {
    setPinUnsigned("OpCode", OpCodes.AND);
    setPinUnsigned("functionCode", FuncCodes.AND);
    run();
    Assert.assertEquals("AND: RegDest",  false, readPin("RegDest"));
    Assert.assertEquals("AND: Branch",   false, readPin("Branch"));
	Assert.assertEquals("AND: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("AND: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("AND: ALUop", 2, readPinUnsigned("ALUop"));
    Assert.assertEquals("AND: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("AND: ALUsrc",   false, readPin("ALUsrc"));
	Assert.assertEquals("AND: RegWrite", true, readPin("RegWrite"));
	Assert.assertEquals("AND: Jump",     false, readPin("Jump"));
	Assert.assertEquals("AND: jal",      false, readPin("jal"));
	Assert.assertEquals("AND: jr",       false, readPin("jr"));
	Assert.assertEquals("AND: bne",      false, readPin("bne"));
	Assert.assertEquals("AND: Halt",     false, readPin("Halt"));
	Assert.assertEquals("AND: ZeroExtend", true, readPin("ZeroExtend"));
  }
  
  @Test
  public void testANDI() {
    setPinUnsigned("OpCode", OpCodes.ANDI);
    setPinUnsigned("functionCode", FuncCodes.AND);
    run();
    Assert.assertEquals("ANDI: RegDest",  true, readPin("RegDest"));
    Assert.assertEquals("ANDI: Branch",   false, readPin("Branch"));
	Assert.assertEquals("ANDI: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("ANDI: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("ANDI: ALUop", 2, readPinUnsigned("ALUop"));
    Assert.assertEquals("ANDI: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("ANDI: ALUsrc",   true, readPin("ALUsrc"));
	Assert.assertEquals("ANDI: RegWrite", true, readPin("RegWrite"));
	Assert.assertEquals("ANDI: Jump",     false, readPin("Jump"));
	Assert.assertEquals("ANDI: jal",      false, readPin("jal"));
	Assert.assertEquals("ANDI: jr",       false, readPin("jr"));
	Assert.assertEquals("ANDI: bne",      false, readPin("bne"));
	Assert.assertEquals("ANDI: Halt",     false, readPin("Halt"));
	Assert.assertEquals("ANDI: ZeroExtend", true, readPin("ZeroExtend"));
  }
  
  @Test
  public void testBEQ() {
    setPinUnsigned("OpCode", OpCodes.BEQ);
    setPinUnsigned("functionCode", FuncCodes.BEQ);
    run();
    Assert.assertEquals("BEQ: RegDest",  true, readPin("RegDest"));
    Assert.assertEquals("BEQ: Branch",   true, readPin("Branch"));
	Assert.assertEquals("BEQ: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("BEQ: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("BEQ: ALUop", 1, readPinUnsigned("ALUop"));
    Assert.assertEquals("BEQ: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("BEQ: ALUsrc",   true, readPin("ALUsrc"));
	Assert.assertEquals("BEQ: RegWrite", false, readPin("RegWrite"));
	Assert.assertEquals("BEQ: Jump",     false, readPin("Jump"));
	Assert.assertEquals("BEQ: jal",      false, readPin("jal"));
	Assert.assertEquals("BEQ: jr",       false, readPin("jr"));
	Assert.assertEquals("BEQ: bne",      false, readPin("bne"));
	Assert.assertEquals("BEQ: Halt",     false, readPin("Halt"));
	Assert.assertEquals("BEQ: ZeroExtend", false, readPin("ZeroExtend"));
  }
  
  @Test
  public void testBNE() {
    setPinUnsigned("OpCode", OpCodes.BNE);
    setPinUnsigned("functionCode", FuncCodes.BNE);
    run();
    Assert.assertEquals("BNE: RegDest",  true, readPin("RegDest"));
    Assert.assertEquals("BNE: Branch",   false, readPin("Branch"));
	Assert.assertEquals("BNE: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("BNE: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("BNE: ALUop", 1, readPinUnsigned("ALUop"));
    Assert.assertEquals("BNE: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("BNE: ALUsrc",   true, readPin("ALUsrc"));
	Assert.assertEquals("BNE: RegWrite", false, readPin("RegWrite"));
	Assert.assertEquals("BNE: Jump",     false, readPin("Jump"));
	Assert.assertEquals("BNE: jal",      false, readPin("jal"));
	Assert.assertEquals("BNE: jr",       false, readPin("jr"));
	Assert.assertEquals("BNE: bne",      true, readPin("bne"));
	Assert.assertEquals("BNE: Halt",     false, readPin("Halt"));
	Assert.assertEquals("BNE: ZeroExtend", false, readPin("ZeroExtend"));
  }
  
  @Test
  public void testHALT() {
    setPinUnsigned("OpCode", OpCodes.HALT);
    setPinUnsigned("functionCode", FuncCodes.HALT);
    run();
    Assert.assertEquals("HALT: RegDest",  true, readPin("RegDest"));
    Assert.assertEquals("HALT: Branch",   false, readPin("Branch"));
	Assert.assertEquals("HALT: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("HALT: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("HALT: ALUop", 0, readPinUnsigned("ALUop"));
    Assert.assertEquals("HALT: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("HALT: ALUsrc",   true, readPin("ALUsrc"));
	Assert.assertEquals("HALT: RegWrite", false, readPin("RegWrite"));
	Assert.assertEquals("HALT: Jump",     false, readPin("Jump"));
	Assert.assertEquals("HALT: jal",      false, readPin("jal"));
	Assert.assertEquals("HALT: jr",       false, readPin("jr"));
	Assert.assertEquals("HALT: bne",      false, readPin("bne"));
	Assert.assertEquals("HALT: Halt",     true, readPin("Halt"));
	Assert.assertEquals("HALT: ZeroExtend", false, readPin("ZeroExtend"));
  }
  
  @Test
  public void testJUMP() {
    setPinUnsigned("OpCode", OpCodes.J);
    setPinUnsigned("functionCode", FuncCodes.J);
    run();
    Assert.assertEquals("JUMP: RegDest",  true, readPin("RegDest"));
    Assert.assertEquals("JUMP: Branch",   false, readPin("Branch"));
	Assert.assertEquals("JUMP: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("JUMP: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("JUMP: ALUop", 0, readPinUnsigned("ALUop"));
    Assert.assertEquals("JUMP: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("JUMP: ALUsrc",   true, readPin("ALUsrc"));
	Assert.assertEquals("JUMP: RegWrite", false, readPin("RegWrite"));
	Assert.assertEquals("JUMP: Jump",     true, readPin("Jump"));
	Assert.assertEquals("JUMP: jal",      false, readPin("jal"));
	Assert.assertEquals("JUMP: jr",       false, readPin("jr"));
	Assert.assertEquals("JUMP: bne",      false, readPin("bne"));
	Assert.assertEquals("JUMP: Halt",     false, readPin("Halt"));
	Assert.assertEquals("JUMP: ZeroExtend", false, readPin("ZeroExtend"));
  }
  
  @Test
  public void testJAL() {
    setPinUnsigned("OpCode", OpCodes.JAL);
    setPinUnsigned("functionCode", FuncCodes.JAL);
    run();
    Assert.assertEquals("JAL: RegDest",  true, readPin("RegDest"));
    Assert.assertEquals("JAL: Branch",   false, readPin("Branch"));
	Assert.assertEquals("JAL: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("JAL: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("JAL: ALUop", 0, readPinUnsigned("ALUop"));
    Assert.assertEquals("JAL: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("JAL: ALUsrc",   true, readPin("ALUsrc"));
	Assert.assertEquals("JAL: RegWrite", false, readPin("RegWrite"));
	Assert.assertEquals("JAL: Jump",     false, readPin("Jump"));
	Assert.assertEquals("JAL: jal",      true, readPin("jal"));
	Assert.assertEquals("JAL: jr",       false, readPin("jr"));
	Assert.assertEquals("JAL: bne",      false, readPin("bne"));
	Assert.assertEquals("JAL: Halt",     false, readPin("Halt"));
	Assert.assertEquals("JAL: ZeroExtend", false, readPin("ZeroExtend"));
  }
  
  @Test
  public void testJR() {
    setPinUnsigned("OpCode", OpCodes.JR);
    setPinUnsigned("functionCode", FuncCodes.JR);
    run();
    Assert.assertEquals("JR: RegDest",  false, readPin("RegDest"));
    Assert.assertEquals("JR: Branch",   false, readPin("Branch"));
	Assert.assertEquals("JR: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("JR: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("JR: ALUop", 0, readPinUnsigned("ALUop"));
    Assert.assertEquals("JR: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("JR: ALUsrc",   false, readPin("ALUsrc"));
	Assert.assertEquals("JR: RegWrite", false, readPin("RegWrite"));
	Assert.assertEquals("JR: Jump",     false, readPin("Jump"));
	Assert.assertEquals("JR: jal",      false, readPin("jal"));
	Assert.assertEquals("JR: jr",       true, readPin("jr"));
	Assert.assertEquals("JR: bne",      false, readPin("bne"));
	Assert.assertEquals("JR: Halt",     false, readPin("Halt"));
	Assert.assertEquals("JR: ZeroExtend", false, readPin("ZeroExtend"));
  }
  
  @Test
  public void testLW() {
    setPinUnsigned("OpCode", OpCodes.LW);
    setPinUnsigned("functionCode", FuncCodes.LW);
    run();
    Assert.assertEquals("LW: RegDest",  true, readPin("RegDest"));
    Assert.assertEquals("LW: Branch",   false, readPin("Branch"));
	Assert.assertEquals("LW: MemRead",  true, readPin("MemRead"));
	Assert.assertEquals("LW: MemToReg", true, readPin("MemToReg"));
	Assert.assertEquals("LW: ALUop", 0, readPinUnsigned("ALUop"));
    Assert.assertEquals("LW: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("LW: ALUsrc",   true, readPin("ALUsrc"));
	Assert.assertEquals("LW: RegWrite", true, readPin("RegWrite"));
	Assert.assertEquals("LW: Jump",     false, readPin("Jump"));
	Assert.assertEquals("LW: jal",      false, readPin("jal"));
	Assert.assertEquals("LW: jr",       false, readPin("jr"));
	Assert.assertEquals("LW: bne",      false, readPin("bne"));
	Assert.assertEquals("LW: Halt",     false, readPin("Halt"));
	Assert.assertEquals("LW: ZeroExtend", false, readPin("ZeroExtend"));
  }
  
  @Test
  public void testLUI() {
    setPinUnsigned("OpCode", OpCodes.LUI);
    setPinUnsigned("functionCode", FuncCodes.LUI);
    run();
    Assert.assertEquals("LUI: RegDest",  true, readPin("RegDest"));
    Assert.assertEquals("LUI: Branch",   false, readPin("Branch"));
	Assert.assertEquals("LUI: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("LUI: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("LUI: ALUop", 6, readPinUnsigned("ALUop"));
    Assert.assertEquals("LUI: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("LUI: ALUsrc",   true, readPin("ALUsrc"));
	Assert.assertEquals("LUI: RegWrite", true, readPin("RegWrite"));
	Assert.assertEquals("LUI: Jump",     false, readPin("Jump"));
	Assert.assertEquals("LUI: jal",      false, readPin("jal"));
	Assert.assertEquals("LUI: jr",       false, readPin("jr"));
	Assert.assertEquals("LUI: bne",      false, readPin("bne"));
	Assert.assertEquals("LUI: Halt",     false, readPin("Halt"));
	Assert.assertEquals("LUI: ZeroExtend", false, readPin("ZeroExtend"));
  }
  
  @Test
  public void testNOR() {
    setPinUnsigned("OpCode", OpCodes.NOR);
    setPinUnsigned("functionCode", FuncCodes.NOR);
    run();
    Assert.assertEquals("NOR: RegDest",  false, readPin("RegDest"));
    Assert.assertEquals("NOR: Branch",   false, readPin("Branch"));
	Assert.assertEquals("NOR: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("NOR: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("NOR: ALUop", 4, readPinUnsigned("ALUop"));
    Assert.assertEquals("NOR: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("NOR: ALUsrc",   false, readPin("ALUsrc"));
	Assert.assertEquals("NOR: RegWrite", true, readPin("RegWrite"));
	Assert.assertEquals("NOR: Jump",     false, readPin("Jump"));
	Assert.assertEquals("NOR: jal",      false, readPin("jal"));
	Assert.assertEquals("NOR: jr",       false, readPin("jr"));
	Assert.assertEquals("NOR: bne",      false, readPin("bne"));
	Assert.assertEquals("NOR: Halt",     false, readPin("Halt"));
	Assert.assertEquals("NOR: ZeroExtend", false, readPin("ZeroExtend"));
  }
  
  @Test
  public void testOR() {
    setPinUnsigned("OpCode", OpCodes.OR);
    setPinUnsigned("functionCode", FuncCodes.OR);
    run();
    Assert.assertEquals("OR: RegDest",  false, readPin("RegDest"));
    Assert.assertEquals("OR: Branch",   false, readPin("Branch"));
	Assert.assertEquals("OR: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("OR: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("OR: ALUop", 3, readPinUnsigned("ALUop"));
    Assert.assertEquals("OR: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("OR: ALUsrc",   false, readPin("ALUsrc"));
	Assert.assertEquals("OR: RegWrite", true, readPin("RegWrite"));
	Assert.assertEquals("OR: Jump",     false, readPin("Jump"));
	Assert.assertEquals("OR: jal",      false, readPin("jal"));
	Assert.assertEquals("OR: jr",       false, readPin("jr"));
	Assert.assertEquals("OR: bne",      false, readPin("bne"));
	Assert.assertEquals("OR: Halt",     false, readPin("Halt"));
	Assert.assertEquals("OR: ZeroExtend", true, readPin("ZeroExtend"));
  }
  
  @Test
  public void testORI() {
    setPinUnsigned("OpCode", OpCodes.ORI);
    setPinUnsigned("functionCode", FuncCodes.ORI);
    run();
    Assert.assertEquals("ORI: RegDest",  true, readPin("RegDest"));
    Assert.assertEquals("ORI: Branch",   false, readPin("Branch"));
	Assert.assertEquals("ORI: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("ORI: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("ORI: ALUop", 3, readPinUnsigned("ALUop"));
    Assert.assertEquals("ORI: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("ORI: ALUsrc",   true, readPin("ALUsrc"));
	Assert.assertEquals("ORI: RegWrite", true, readPin("RegWrite"));
	Assert.assertEquals("ORI: Jump",     false, readPin("Jump"));
	Assert.assertEquals("ORI: jal",      false, readPin("jal"));
	Assert.assertEquals("ORI: jr",       false, readPin("jr"));
	Assert.assertEquals("ORI: bne",      false, readPin("bne"));
	Assert.assertEquals("ORI: Halt",     false, readPin("Halt"));
	Assert.assertEquals("ORI: ZeroExtend", true, readPin("ZeroExtend"));
  }
  
  @Test
  public void testSLT() {
    setPinUnsigned("OpCode", OpCodes.SLT);
    setPinUnsigned("functionCode", FuncCodes.SLT);
    run();
    Assert.assertEquals("SLT: RegDest",  false, readPin("RegDest"));
    Assert.assertEquals("SLT: Branch",   false, readPin("Branch"));
	Assert.assertEquals("SLT: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("SLT: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("SLT: ALUop", 15, readPinUnsigned("ALUop"));
    Assert.assertEquals("SLT: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("SLT: ALUsrc",   false, readPin("ALUsrc"));
	Assert.assertEquals("SLT: RegWrite", true, readPin("RegWrite"));
	Assert.assertEquals("SLT: Jump",     false, readPin("Jump"));
	Assert.assertEquals("SLT: jal",      false, readPin("jal"));
	Assert.assertEquals("SLT: jr",       false, readPin("jr"));
	Assert.assertEquals("SLT: bne",      false, readPin("bne"));
	Assert.assertEquals("SLT: Halt",     false, readPin("Halt"));
	Assert.assertEquals("SLT: ZeroExtend", false, readPin("ZeroExtend"));
  }
  
  @Test
  public void testSLTU() {
    setPinUnsigned("OpCode", OpCodes.SLTU);
    setPinUnsigned("functionCode", FuncCodes.SLTU);
    run();
    Assert.assertEquals("SLTU: RegDest",  false, readPin("RegDest"));
    Assert.assertEquals("SLTU: Branch",   false, readPin("Branch"));
	Assert.assertEquals("SLTU: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("SLTU: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("SLTU: ALUop", 7, readPinUnsigned("ALUop"));
    Assert.assertEquals("SLTU: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("SLTU: ALUsrc",   false, readPin("ALUsrc"));
	Assert.assertEquals("SLTU: RegWrite", true, readPin("RegWrite"));
	Assert.assertEquals("SLTU: Jump",     false, readPin("Jump"));
	Assert.assertEquals("SLTU: jal",      false, readPin("jal"));
	Assert.assertEquals("SLTU: jr",       false, readPin("jr"));
	Assert.assertEquals("SLTU: bne",      false, readPin("bne"));
	Assert.assertEquals("SLTU: Halt",     false, readPin("Halt"));
	Assert.assertEquals("SLTU: ZeroExtend", false, readPin("ZeroExtend"));
  }
  
  @Test
  public void testSLTI() {
    setPinUnsigned("OpCode", OpCodes.SLTI);
    setPinUnsigned("functionCode", FuncCodes.SLTI);
    run();
    Assert.assertEquals("SLTI: RegDest",  true, readPin("RegDest"));
    Assert.assertEquals("SLTI: Branch",   false, readPin("Branch"));
	Assert.assertEquals("SLTI: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("SLTI: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("SLTI: ALUop", 15, readPinUnsigned("ALUop"));
    Assert.assertEquals("SLTI: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("SLTI: ALUsrc",   true, readPin("ALUsrc"));
	Assert.assertEquals("SLTI: RegWrite", true, readPin("RegWrite"));
	Assert.assertEquals("SLTI: Jump",     false, readPin("Jump"));
	Assert.assertEquals("SLTI: jal",      false, readPin("jal"));
	Assert.assertEquals("SLTI: jr",       false, readPin("jr"));
	Assert.assertEquals("SLTI: bne",      false, readPin("bne"));
	Assert.assertEquals("SLTI: Halt",     false, readPin("Halt"));
	Assert.assertEquals("SLTI: ZeroExtend", false, readPin("ZeroExtend"));
  }
  
  @Test
  public void testSLTIU() {
    setPinUnsigned("OpCode", OpCodes.SLTIU);
    setPinUnsigned("functionCode", FuncCodes.SLTIU);
    run();
    Assert.assertEquals("SLTIU: RegDest",  true, readPin("RegDest"));
    Assert.assertEquals("SLTIU: Branch",   false, readPin("Branch"));
	Assert.assertEquals("SLTIU: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("SLTIU: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("SLTIU: ALUop", 7, readPinUnsigned("ALUop"));
    Assert.assertEquals("SLTIU: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("SLTIU: ALUsrc",   true, readPin("ALUsrc"));
	Assert.assertEquals("SLTIU: RegWrite", true, readPin("RegWrite"));
	Assert.assertEquals("SLTIU: Jump",     false, readPin("Jump"));
	Assert.assertEquals("SLTIU: jal",      false, readPin("jal"));
	Assert.assertEquals("SLTIU: jr",       false, readPin("jr"));
	Assert.assertEquals("SLTIU: bne",      false, readPin("bne"));
	Assert.assertEquals("SLTIU: Halt",     false, readPin("Halt"));
	Assert.assertEquals("SLTIU: ZeroExtend", false, readPin("ZeroExtend"));
  }
  
  @Test
  public void testSW() {
    setPinUnsigned("OpCode", OpCodes.SW);
    setPinUnsigned("functionCode", FuncCodes.SW);
    run();
    Assert.assertEquals("SW: RegDest",  true, readPin("RegDest"));
    Assert.assertEquals("SW: Branch",   false, readPin("Branch"));
	Assert.assertEquals("SW: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("SW: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("SW: ALUop", 0, readPinUnsigned("ALUop"));
    Assert.assertEquals("SW: MemWrite", true, readPin("MemWrite"));
	Assert.assertEquals("SW: ALUsrc",   true, readPin("ALUsrc"));
	Assert.assertEquals("SW: RegWrite", false, readPin("RegWrite"));
	Assert.assertEquals("SW: Jump",     false, readPin("Jump"));
	Assert.assertEquals("SW: jal",      false, readPin("jal"));
	Assert.assertEquals("SW: jr",       false, readPin("jr"));
	Assert.assertEquals("SW: bne",      false, readPin("bne"));
	Assert.assertEquals("SW: Halt",     false, readPin("Halt"));
	Assert.assertEquals("SW: ZeroExtend", false, readPin("ZeroExtend"));
  }
  
  @Test
  public void testSUB() {
    setPinUnsigned("OpCode", OpCodes.SUB);
    setPinUnsigned("functionCode", FuncCodes.SUB);
    run();
    Assert.assertEquals("SUB: RegDest",  false, readPin("RegDest"));
    Assert.assertEquals("SUB: Branch",   false, readPin("Branch"));
	Assert.assertEquals("SUB: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("SUB: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("SUB: ALUop", 1, readPinUnsigned("ALUop"));
    Assert.assertEquals("SUB: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("SUB: ALUsrc",   false, readPin("ALUsrc"));
	Assert.assertEquals("SUB: RegWrite", true, readPin("RegWrite"));
	Assert.assertEquals("SUB: Jump",     false, readPin("Jump"));
	Assert.assertEquals("SUB: jal",      false, readPin("jal"));
	Assert.assertEquals("SUB: jr",       false, readPin("jr"));
	Assert.assertEquals("SUB: bne",      false, readPin("bne"));
	Assert.assertEquals("SUB: Halt",     false, readPin("Halt"));
	Assert.assertEquals("SUB: ZeroExtend", false, readPin("ZeroExtend"));
  }
  
  @Test
  public void testSUBU() {
    setPinUnsigned("OpCode", OpCodes.SUBU);
    setPinUnsigned("functionCode", FuncCodes.SUBU);
    run();
    Assert.assertEquals("SUBU: RegDest",  false, readPin("RegDest"));
    Assert.assertEquals("SUBU: Branch",   false, readPin("Branch"));
	Assert.assertEquals("SUBU: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("SUBU: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("SUBU: ALUop", 1, readPinUnsigned("ALUop"));
    Assert.assertEquals("SUBU: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("SUBU: ALUsrc",   false, readPin("ALUsrc"));
	Assert.assertEquals("SUBU: RegWrite", true, readPin("RegWrite"));
	Assert.assertEquals("SUBU: Jump",     false, readPin("Jump"));
	Assert.assertEquals("SUBU: jal",      false, readPin("jal"));
	Assert.assertEquals("SUBU: jr",       false, readPin("jr"));
	Assert.assertEquals("SUBU: bne",      false, readPin("bne"));
	Assert.assertEquals("SUBU: Halt",     false, readPin("Halt"));
	Assert.assertEquals("SUBU: ZeroExtend", false, readPin("ZeroExtend"));
  }
  
  @Test
  public void testXOR() {
    setPinUnsigned("OpCode", OpCodes.XOR);
    setPinUnsigned("functionCode", FuncCodes.XOR);
    run();
    Assert.assertEquals("XOR: RegDest",  false, readPin("RegDest"));
    Assert.assertEquals("XOR: Branch",   false, readPin("Branch"));
	Assert.assertEquals("XOR: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("XOR: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("XOR: ALUop", 5, readPinUnsigned("ALUop"));
    Assert.assertEquals("XOR: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("XOR: ALUsrc",   false, readPin("ALUsrc"));
	Assert.assertEquals("XOR: RegWrite", true, readPin("RegWrite"));
	Assert.assertEquals("XOR: Jump",     false, readPin("Jump"));
	Assert.assertEquals("XOR: jal",      false, readPin("jal"));
	Assert.assertEquals("XOR: jr",       false, readPin("jr"));
	Assert.assertEquals("XOR: bne",      false, readPin("bne"));
	Assert.assertEquals("XOR: Halt",     false, readPin("Halt"));
	Assert.assertEquals("XOR: ZeroExtend", true, readPin("ZeroExtend"));
  }
  
  @Test
  public void testXORI() {
    setPinUnsigned("OpCode", OpCodes.XORI);
    setPinUnsigned("functionCode", FuncCodes.XORI);
    run();
    Assert.assertEquals("XORI: RegDest",  true, readPin("RegDest"));
    Assert.assertEquals("XORI: Branch",   false, readPin("Branch"));
	Assert.assertEquals("XORI: MemRead",  false, readPin("MemRead"));
	Assert.assertEquals("XORI: MemToReg", false, readPin("MemToReg"));
	Assert.assertEquals("XORI: ALUop", 5, readPinUnsigned("ALUop"));
    Assert.assertEquals("XORI: MemWrite", false, readPin("MemWrite"));
	Assert.assertEquals("XORI: ALUsrc",   true, readPin("ALUsrc"));
	Assert.assertEquals("XORI: RegWrite", true, readPin("RegWrite"));
	Assert.assertEquals("XORI: Jump",     false, readPin("Jump"));
	Assert.assertEquals("XORI: jal",      false, readPin("jal"));
	Assert.assertEquals("XORI: jr",       false, readPin("jr"));
	Assert.assertEquals("XORI: bne",      false, readPin("bne"));
	Assert.assertEquals("XORI: Halt",     false, readPin("Halt"));
	Assert.assertEquals("XORI: ZeroExtend", true, readPin("ZeroExtend"));
  }  
}
