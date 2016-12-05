package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.RealmObjectSchema;
import io.realm.RealmSchema;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.SharedRealm;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ScoreRealmProxy extends com.example.lg403756.td5_projet.Score
    implements RealmObjectProxy, ScoreRealmProxyInterface {

    static final class ScoreColumnInfo extends ColumnInfo
        implements Cloneable {

        public long idScoreIndex;
        public long scoreIndex;

        ScoreColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(2);
            this.idScoreIndex = getValidColumnIndex(path, table, "Score", "idScore");
            indicesMap.put("idScore", this.idScoreIndex);
            this.scoreIndex = getValidColumnIndex(path, table, "Score", "score");
            indicesMap.put("score", this.scoreIndex);

            setIndicesMap(indicesMap);
        }

        @Override
        public final void copyColumnInfoFrom(ColumnInfo other) {
            final ScoreColumnInfo otherInfo = (ScoreColumnInfo) other;
            this.idScoreIndex = otherInfo.idScoreIndex;
            this.scoreIndex = otherInfo.scoreIndex;

            setIndicesMap(otherInfo.getIndicesMap());
        }

        @Override
        public final ScoreColumnInfo clone() {
            return (ScoreColumnInfo) super.clone();
        }

    }
    private ScoreColumnInfo columnInfo;
    private ProxyState proxyState;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("idScore");
        fieldNames.add("score");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    ScoreRealmProxy() {
        if (proxyState == null) {
            injectObjectContext();
        }
        proxyState.setConstructionFinished();
    }

    private void injectObjectContext() {
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ScoreColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState(com.example.lg403756.td5_projet.Score.class, this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @SuppressWarnings("cast")
    public int realmGet$idScore() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idScoreIndex);
    }

    public void realmSet$idScore(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'idScore' cannot be changed after object was created.");
    }

    @SuppressWarnings("cast")
    public int realmGet$score() {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.scoreIndex);
    }

    public void realmSet$score(int value) {
        if (proxyState == null) {
            // Called from model's constructor. Inject context.
            injectObjectContext();
        }

        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.scoreIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.scoreIndex, value);
    }

    public static RealmObjectSchema createRealmObjectSchema(RealmSchema realmSchema) {
        if (!realmSchema.contains("Score")) {
            RealmObjectSchema realmObjectSchema = realmSchema.create("Score");
            realmObjectSchema.add(new Property("idScore", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED));
            realmObjectSchema.add(new Property("score", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED));
            return realmObjectSchema;
        }
        return realmSchema.get("Score");
    }

    public static Table initTable(SharedRealm sharedRealm) {
        if (!sharedRealm.hasTable("class_Score")) {
            Table table = sharedRealm.getTable("class_Score");
            table.addColumn(RealmFieldType.INTEGER, "idScore", Table.NOT_NULLABLE);
            table.addColumn(RealmFieldType.INTEGER, "score", Table.NOT_NULLABLE);
            table.addSearchIndex(table.getColumnIndex("idScore"));
            table.setPrimaryKey("idScore");
            return table;
        }
        return sharedRealm.getTable("class_Score");
    }

    public static ScoreColumnInfo validateTable(SharedRealm sharedRealm, boolean allowExtraColumns) {
        if (sharedRealm.hasTable("class_Score")) {
            Table table = sharedRealm.getTable("class_Score");
            final long columnCount = table.getColumnCount();
            if (columnCount != 2) {
                if (columnCount < 2) {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is less than expected - expected 2 but was " + columnCount);
                }
                if (allowExtraColumns) {
                    RealmLog.debug("Field count is more than expected - expected 2 but was %1$d", columnCount);
                } else {
                    throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field count is more than expected - expected 2 but was " + columnCount);
                }
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < columnCount; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final ScoreColumnInfo columnInfo = new ScoreColumnInfo(sharedRealm.getPath(), table);

            if (!columnTypes.containsKey("idScore")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'idScore' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("idScore") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'idScore' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.idScoreIndex) && table.findFirstNull(columnInfo.idScoreIndex) != TableOrView.NO_MATCH) {
                throw new IllegalStateException("Cannot migrate an object with null value in field 'idScore'. Either maintain the same type for primary key field 'idScore', or remove the object with null value before migration.");
            }
            if (table.getPrimaryKey() != table.getColumnIndex("idScore")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Primary key not defined for field 'idScore' in existing Realm file. Add @PrimaryKey.");
            }
            if (!table.hasSearchIndex(table.getColumnIndex("idScore"))) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Index not defined for field 'idScore' in existing Realm file. Either set @Index or migrate using io.realm.internal.Table.removeSearchIndex().");
            }
            if (!columnTypes.containsKey("score")) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Missing field 'score' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("score") != RealmFieldType.INTEGER) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Invalid type 'int' for field 'score' in existing Realm file.");
            }
            if (table.isColumnNullable(columnInfo.scoreIndex)) {
                throw new RealmMigrationNeededException(sharedRealm.getPath(), "Field 'score' does support null values in the existing Realm file. Use corresponding boxed type for field 'score' or migrate using RealmObjectSchema.setNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(sharedRealm.getPath(), "The 'Score' class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_Score";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static com.example.lg403756.td5_projet.Score createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.example.lg403756.td5_projet.Score obj = null;
        if (update) {
            Table table = realm.getTable(com.example.lg403756.td5_projet.Score.class);
            long pkColumnIndex = table.getPrimaryKey();
            long rowIndex = TableOrView.NO_MATCH;
            if (!json.isNull("idScore")) {
                rowIndex = table.findFirstLong(pkColumnIndex, json.getLong("idScore"));
            }
            if (rowIndex != TableOrView.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.lg403756.td5_projet.Score.class), false, Collections.<String> emptyList());
                    obj = new io.realm.ScoreRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("idScore")) {
                if (json.isNull("idScore")) {
                    obj = (io.realm.ScoreRealmProxy) realm.createObjectInternal(com.example.lg403756.td5_projet.Score.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.ScoreRealmProxy) realm.createObjectInternal(com.example.lg403756.td5_projet.Score.class, json.getInt("idScore"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'idScore'.");
            }
        }
        if (json.has("score")) {
            if (json.isNull("score")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'score' to null.");
            } else {
                ((ScoreRealmProxyInterface) obj).realmSet$score((int) json.getInt("score"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.example.lg403756.td5_projet.Score createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        com.example.lg403756.td5_projet.Score obj = new com.example.lg403756.td5_projet.Score();
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("idScore")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'idScore' to null.");
                } else {
                    ((ScoreRealmProxyInterface) obj).realmSet$idScore((int) reader.nextInt());
                }
                jsonHasPrimaryKey = true;
            } else if (name.equals("score")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'score' to null.");
                } else {
                    ((ScoreRealmProxyInterface) obj).realmSet$score((int) reader.nextInt());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'idScore'.");
        }
        obj = realm.copyToRealm(obj);
        return obj;
    }

    public static com.example.lg403756.td5_projet.Score copyOrUpdate(Realm realm, com.example.lg403756.td5_projet.Score object, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().threadId != realm.threadId) {
            throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
        }
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return object;
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.example.lg403756.td5_projet.Score) cachedRealmObject;
        } else {
            com.example.lg403756.td5_projet.Score realmObject = null;
            boolean canUpdate = update;
            if (canUpdate) {
                Table table = realm.getTable(com.example.lg403756.td5_projet.Score.class);
                long pkColumnIndex = table.getPrimaryKey();
                long rowIndex = table.findFirstLong(pkColumnIndex, ((ScoreRealmProxyInterface) object).realmGet$idScore());
                if (rowIndex != TableOrView.NO_MATCH) {
                    try {
                        objectContext.set(realm, table.getUncheckedRow(rowIndex), realm.schema.getColumnInfo(com.example.lg403756.td5_projet.Score.class), false, Collections.<String> emptyList());
                        realmObject = new io.realm.ScoreRealmProxy();
                        cache.put(object, (RealmObjectProxy) realmObject);
                    } finally {
                        objectContext.clear();
                    }
                } else {
                    canUpdate = false;
                }
            }

            if (canUpdate) {
                return update(realm, realmObject, object, cache);
            } else {
                return copy(realm, object, update, cache);
            }
        }
    }

    public static com.example.lg403756.td5_projet.Score copy(Realm realm, com.example.lg403756.td5_projet.Score newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.example.lg403756.td5_projet.Score) cachedRealmObject;
        } else {
            // rejecting default values to avoid creating unexpected objects from RealmModel/RealmList fields.
            com.example.lg403756.td5_projet.Score realmObject = realm.createObjectInternal(com.example.lg403756.td5_projet.Score.class, ((ScoreRealmProxyInterface) newObject).realmGet$idScore(), false, Collections.<String>emptyList());
            cache.put(newObject, (RealmObjectProxy) realmObject);
            ((ScoreRealmProxyInterface) realmObject).realmSet$score(((ScoreRealmProxyInterface) newObject).realmGet$score());
            return realmObject;
        }
    }

    public static long insert(Realm realm, com.example.lg403756.td5_projet.Score object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.lg403756.td5_projet.Score.class);
        long tableNativePtr = table.getNativeTablePointer();
        ScoreColumnInfo columnInfo = (ScoreColumnInfo) realm.schema.getColumnInfo(com.example.lg403756.td5_projet.Score.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((ScoreRealmProxyInterface) object).realmGet$idScore();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ScoreRealmProxyInterface) object).realmGet$idScore());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((ScoreRealmProxyInterface) object).realmGet$idScore(), false);
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.scoreIndex, rowIndex, ((ScoreRealmProxyInterface)object).realmGet$score(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.lg403756.td5_projet.Score.class);
        long tableNativePtr = table.getNativeTablePointer();
        ScoreColumnInfo columnInfo = (ScoreColumnInfo) realm.schema.getColumnInfo(com.example.lg403756.td5_projet.Score.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.lg403756.td5_projet.Score object = null;
        while (objects.hasNext()) {
            object = (com.example.lg403756.td5_projet.Score) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((ScoreRealmProxyInterface) object).realmGet$idScore();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ScoreRealmProxyInterface) object).realmGet$idScore());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((ScoreRealmProxyInterface) object).realmGet$idScore(), false);
                } else {
                    Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
                }
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.scoreIndex, rowIndex, ((ScoreRealmProxyInterface)object).realmGet$score(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.example.lg403756.td5_projet.Score object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.example.lg403756.td5_projet.Score.class);
        long tableNativePtr = table.getNativeTablePointer();
        ScoreColumnInfo columnInfo = (ScoreColumnInfo) realm.schema.getColumnInfo(com.example.lg403756.td5_projet.Score.class);
        long pkColumnIndex = table.getPrimaryKey();
        long rowIndex = TableOrView.NO_MATCH;
        Object primaryKeyValue = ((ScoreRealmProxyInterface) object).realmGet$idScore();
        if (primaryKeyValue != null) {
            rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ScoreRealmProxyInterface) object).realmGet$idScore());
        }
        if (rowIndex == TableOrView.NO_MATCH) {
            rowIndex = table.addEmptyRowWithPrimaryKey(((ScoreRealmProxyInterface) object).realmGet$idScore(), false);
        }
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.scoreIndex, rowIndex, ((ScoreRealmProxyInterface)object).realmGet$score(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.example.lg403756.td5_projet.Score.class);
        long tableNativePtr = table.getNativeTablePointer();
        ScoreColumnInfo columnInfo = (ScoreColumnInfo) realm.schema.getColumnInfo(com.example.lg403756.td5_projet.Score.class);
        long pkColumnIndex = table.getPrimaryKey();
        com.example.lg403756.td5_projet.Score object = null;
        while (objects.hasNext()) {
            object = (com.example.lg403756.td5_projet.Score) objects.next();
            if(!cache.containsKey(object)) {
                if (object instanceof RealmObjectProxy && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy)object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                    cache.put(object, ((RealmObjectProxy)object).realmGet$proxyState().getRow$realm().getIndex());
                    continue;
                }
                long rowIndex = TableOrView.NO_MATCH;
                Object primaryKeyValue = ((ScoreRealmProxyInterface) object).realmGet$idScore();
                if (primaryKeyValue != null) {
                    rowIndex = Table.nativeFindFirstInt(tableNativePtr, pkColumnIndex, ((ScoreRealmProxyInterface) object).realmGet$idScore());
                }
                if (rowIndex == TableOrView.NO_MATCH) {
                    rowIndex = table.addEmptyRowWithPrimaryKey(((ScoreRealmProxyInterface) object).realmGet$idScore(), false);
                }
                cache.put(object, rowIndex);
                Table.nativeSetLong(tableNativePtr, columnInfo.scoreIndex, rowIndex, ((ScoreRealmProxyInterface)object).realmGet$score(), false);
            }
        }
    }

    public static com.example.lg403756.td5_projet.Score createDetachedCopy(com.example.lg403756.td5_projet.Score realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.example.lg403756.td5_projet.Score unmanagedObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.example.lg403756.td5_projet.Score)cachedObject.object;
            } else {
                unmanagedObject = (com.example.lg403756.td5_projet.Score)cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            unmanagedObject = new com.example.lg403756.td5_projet.Score();
            cache.put(realmObject, new RealmObjectProxy.CacheData(currentDepth, unmanagedObject));
        }
        ((ScoreRealmProxyInterface) unmanagedObject).realmSet$idScore(((ScoreRealmProxyInterface) realmObject).realmGet$idScore());
        ((ScoreRealmProxyInterface) unmanagedObject).realmSet$score(((ScoreRealmProxyInterface) realmObject).realmGet$score());
        return unmanagedObject;
    }

    static com.example.lg403756.td5_projet.Score update(Realm realm, com.example.lg403756.td5_projet.Score realmObject, com.example.lg403756.td5_projet.Score newObject, Map<RealmModel, RealmObjectProxy> cache) {
        ((ScoreRealmProxyInterface) realmObject).realmSet$score(((ScoreRealmProxyInterface) newObject).realmGet$score());
        return realmObject;
    }

    @Override
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Score = [");
        stringBuilder.append("{idScore:");
        stringBuilder.append(realmGet$idScore());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{score:");
        stringBuilder.append(realmGet$score());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreRealmProxy aScore = (ScoreRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aScore.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aScore.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aScore.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }

}
