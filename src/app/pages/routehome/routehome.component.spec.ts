import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RoutehomeComponent } from './routehome.component';

describe('RoutehomeComponent', () => {
  let component: RoutehomeComponent;
  let fixture: ComponentFixture<RoutehomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RoutehomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RoutehomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
