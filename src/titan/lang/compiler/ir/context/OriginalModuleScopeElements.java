package titan.lang.compiler.ir.context;

import java.util.ArrayList;
import java.util.List;
import titan.lang.runtime.type.Enum;
import titan.lang.runtime.type.EnumType;
import titan.lang.runtime.type.Pointer;
import titan.lang.runtime.type.PointerType;
import titan.lang.runtime.type.PointerTypeGenerics;
import titan.lang.runtime.type.Primitive;
import titan.lang.runtime.type.Procedure;
import titan.lang.runtime.type.ProcedureType;
import titan.lang.runtime.type.ProcedureTypeGenerics;
import titan.lang.runtime.type.Struct;
import titan.lang.runtime.type.StructType;
import titan.lang.runtime.type.StructTypeGenerics;
import titan.lang.runtime.type.Trait;
import titan.lang.runtime.type.TraitGenerics;
import titan.lang.runtime.type.Union;
import titan.lang.runtime.type.UnionType;
import titan.lang.runtime.type.UnionTypeGenerics;

/**
 * .
 *
 * @author tian wei jun
 */
public class OriginalModuleScopeElements {
  // -----no generics type start-----
  public List<EnumType> enumTypes = new ArrayList<>();

  public List<ProcedureType> procedureTypes = new ArrayList<>();
  public List<StructType> structTypes = new ArrayList<>();
  public List<UnionType> unionTypes = new ArrayList<>();
  public List<PointerType> pointerTypes = new ArrayList<>();
  // -----no generics type end-----

  // -----generics type start-----
  public List<ProcedureTypeGenerics> procedureTypeGenerics = new ArrayList<>();
  public List<StructTypeGenerics> structTypeGenerics = new ArrayList<>();
  public List<UnionTypeGenerics> unionTypeGenerics = new ArrayList<>();
  public List<PointerTypeGenerics> pointerTypeGenerics = new ArrayList<>();
  // -----generics type end-----

  // -----var start-----
  public List<Primitive> primitives = new ArrayList<>();
  public List<Enum> enums = new ArrayList<>();
  // 有泛型
  public List<Procedure> procedures = new ArrayList<>();
  public List<Struct> structs = new ArrayList<>();
  public List<Union> unions = new ArrayList<>();
  public List<Pointer> pointers = new ArrayList<>();
  // -----var end-----

  // ----------trait start--------
  public List<Trait> traits = new ArrayList<>();
  public List<TraitGenerics> traitGenerics = new ArrayList<>();
  // ----------trait end----------
}
