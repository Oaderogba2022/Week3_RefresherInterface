package ie.atu.week3_inventory;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private final Inventory inventory;

    public InventoryController() {
        this.inventory = new Inventory(1L, 100); // Dummy data for demonstration
    }

    @GetMapping("/{productId}")
    public InventoryResponse getInventory(@PathVariable Long productId) {
        // Check if the inventory exists for the productId
        if (inventory.getProductId().equals(productId)) {
            return new InventoryResponse(inventory.getProductId(), inventory.getQuantity());
        } else {
            throw new ResourceNotFoundException("Inventory not found for product ID: " + productId);
        }
    }
}
