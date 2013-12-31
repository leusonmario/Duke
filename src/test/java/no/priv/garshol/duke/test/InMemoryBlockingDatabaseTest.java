
package no.priv.garshol.duke.test;

import java.util.ArrayList;
import java.util.Collection;

import no.priv.garshol.duke.Record;
import no.priv.garshol.duke.Database;
import no.priv.garshol.duke.Configuration;
import no.priv.garshol.duke.databases.KeyFunction;
import no.priv.garshol.duke.databases.InMemoryBlockingDatabase;

public class InMemoryBlockingDatabaseTest extends DatabaseTest {

  public Database createDatabase(Configuration config) {
    InMemoryBlockingDatabase db = new InMemoryBlockingDatabase();
    db.setConfiguration(config);

    Collection<KeyFunction> functions = new ArrayList();
    functions.add(new TestKeyFunction());
    db.setKeyFunctions(functions);
    return db;
  }

  private static class TestKeyFunction implements KeyFunction {
    public String makeKey(Record record) {
      return record.getValue("NAME");
    }
  }
}