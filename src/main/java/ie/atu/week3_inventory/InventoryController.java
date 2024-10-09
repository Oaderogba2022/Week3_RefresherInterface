package ie.atu.week3_inventory;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private final Inventory inventory;

    public InventoryController() {
        this.inventory = new Inventory(1L, 100); // Dummy data for demonstration
    }

    @GetMapping("/{productId}")
    public Inventory getInventory(@PathVariable Long productId) {
        if (inventory.getProductId().equals(productId)) {
            return inventory;
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Inventory not found for product ID: " + productId);
        }
    }
}
