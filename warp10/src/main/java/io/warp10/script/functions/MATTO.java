//
//   Copyright 2016  Cityzen Data
//
//   Licensed under the Apache License, Version 2.0 (the "License");
//   you may not use this file except in compliance with the License.
//   You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
//   Unless required by applicable law or agreed to in writing, software
//   distributed under the License is distributed on an "AS IS" BASIS,
//   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//   See the License for the specific language governing permissions and
//   limitations under the License.
//

package io.warp10.script.functions;

import io.warp10.script.NamedWarpScriptFunction;
import io.warp10.script.WarpScriptException;
import io.warp10.script.WarpScriptStack;
import io.warp10.script.WarpScriptStackFunction;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.math3.linear.RealMatrix;

/**
 * Converts a Matrix into nested lists
 */
public class MATTO extends NamedWarpScriptFunction implements WarpScriptStackFunction {
  
  public MATTO(String name) {
    super(name);
  }
  
  @Override
  public Object apply(WarpScriptStack stack) throws WarpScriptException {
    
    Object o = stack.pop();
    
    if (!(o instanceof RealMatrix)) {
      throw new WarpScriptException(getName() + " expects a matrix on top of the stack.");
    }
    
    RealMatrix matrix = (RealMatrix) o;
    
    List<Object> rows = new ArrayList<Object>(matrix.getRowDimension());
    
    double[][] data = matrix.getData();
    
    for (int i = 0; i < matrix.getRowDimension(); i++) {
      List<Object> cols = new ArrayList<Object>(matrix.getColumnDimension());
      for (int j = 0; j < matrix.getColumnDimension(); j++) {
        cols.add(data[i][j]);
      }
      rows.add(cols);
    }

    stack.push(rows);
    
    return stack;
  }
}
