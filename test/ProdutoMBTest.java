/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import enumfiles.ProdutoEnum;
import managedbean.ProdutoDBMB;
import modelo.Categoria;
import modelo.Produto;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author gabri
 */
public class ProdutoMBTest {
    
    public ProdutoMBTest() {
    }
    /*
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    */
    
    
    @Test
    public void testProdutoMB(){
        Produto prod = null;
        ProdutoDBMB prodMB = new ProdutoDBMB();
        prodMB.setProd(prod);
        ProdutoEnum expResult = ProdutoEnum.NULL;
        ProdutoEnum result = prodMB.salvarTest();
        assertEquals(expResult, result);
//------------------- 
        prod = new Produto("Batata", null, 10.0, 3, 0.2);
        expResult = ProdutoEnum.ERRO;
        result = prodMB.salvarTest();
        assertEquals(expResult, result);
//-------------------
        Categoria cat = new Categoria();
        prod = new Produto("Batata", cat, 10.0, 3, 0.2);
        expResult = ProdutoEnum.OK;
        result = prodMB.salvarTest();
        assertEquals(expResult, result);
    }
}
